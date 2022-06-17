package com.mucha.lib.internal.di.modules

import com.mucha.lib.api.DemoApi
import com.mucha.lib.internal.DefaultDemoApi
import com.mucha.lib.internal.db.dao.CategoryDao
import com.mucha.lib.internal.db.dao.DrinkDao
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

/**
 * Default library Dagger module.
 */
@Module
@DisableInstallInCheck
internal class LibModule {

    @Provides
    @Singleton
    fun demoApi(categoryDao: CategoryDao, drinkDao: DrinkDao): DemoApi = DefaultDemoApi(categoryDao, drinkDao)
}
