package com.mucha.lib.internal.work

import android.content.Context
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.mucha.lib.DemoLib
import com.mucha.lib.internal.db.dao.CategoryDao
import com.mucha.lib.internal.db.entities.Category
import com.mucha.lib.internal.service.api.CocktailService
import dagger.Lazy
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Downloads the data from a backend and stores them into database which is considered as a single source of truth.
 */
internal class DatabaseRefreshWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    @Inject
    lateinit var categoryDao: Lazy<CategoryDao>

    @Inject
    lateinit var cocktailsService: CocktailService

    override suspend fun doWork(): Result {
        DemoLib.component.inject(this)

        val response = cocktailsService.getCategories()

        val categories = response.body()
        return if (categories != null) {
            categories.categories.map { Category(name = it.name) }
                .let { categoriesToInsert -> categoryDao.get().insertAll(categoriesToInsert) }

            Result.success()
        } else {
            // Null considered as download error. No matter the response is successful or not.
            if (runAttemptCount < MAX_ATTEMPTS) {
                Result.retry()
            } else {
                Result.failure()
            }
        }
    }

    companion object {

        /**
         * Convenient method to enqueue the worker periodically using pre-defined constraints.
         *
         * @param context The context.
         */
        fun enqueue(context: Context) {
            val constraints =
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

            val workRequest =
                PeriodicWorkRequestBuilder<DatabaseRefreshWorker>(1, TimeUnit.HOURS)
                    .setConstraints(constraints)
                    .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5, TimeUnit.MINUTES)
                    .build()

            // FIXME: Use `KEEP` policy when finished with testing.
            WorkManager.getInstance(context)
                .enqueueUniquePeriodicWork(WORKER_NAME, ExistingPeriodicWorkPolicy.REPLACE, workRequest)
        }
    }
}

private const val WORKER_NAME: String = ".internal.work.DatabaseRefreshWorker"

private const val MAX_ATTEMPTS: Int = 2 // Zero based, thus 3
