package com.mucha.lib.internal

import com.mucha.lib.api.DemoApi
import com.mucha.lib.api.DrinkCategory
import com.mucha.lib.api.RefreshStatus
import com.mucha.lib.internal.db.dao.CategoryDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import com.mucha.lib.internal.db.entities.Category as CategoryEntity

/**
 * Default [DemoApi] implementation.
 *
 * @param categoryDao The [CategoryEntity] related DAO implementation.
 */
internal class DefaultDemoApi(private val categoryDao: CategoryDao) : DemoApi {

    override fun getAllCategories(): Flow<List<DrinkCategory>> =
        categoryDao.getAll().map { entities ->
            entities.map { entity ->
                DrinkCategory(name = entity.name)
            }
        }

    // TODO: Replace dummy implementation with real one. Extract logic from DatabaseRefreshWorker into internal
    //  "RefreshManager" and integrate onto both places.
    override fun refreshCategories(): Flow<RefreshStatus> =
        flow {
            emit(RefreshStatus.Preparing)
            delay(500)
            emit(RefreshStatus.Downloading)
            delay(5000)
            emit(RefreshStatus.Success)
        }
}
