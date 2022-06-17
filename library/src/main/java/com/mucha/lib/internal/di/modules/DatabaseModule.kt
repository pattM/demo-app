package com.mucha.lib.internal.di.modules

import android.app.Application
import com.mucha.lib.internal.db.DemoDatabase
import com.mucha.lib.internal.db.dao.CategoryDao
import com.mucha.lib.internal.db.dao.DrinkDao
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

/**
 * Dagger module for providing Database related classes.
 */
@Module
@DisableInstallInCheck
internal object DatabaseModule {

    @Provides
    @Singleton
    fun database(application: Application): DemoDatabase = DemoDatabase.create(application)

    @Provides
    @Reusable
    fun categoryDao(database: DemoDatabase): CategoryDao = database.categoryDao

    @Provides
    @Reusable
    fun drinkDao(database: DemoDatabase): DrinkDao = database.drinkDao
}
