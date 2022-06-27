package com.mucha.lib.internal.di.modules

import com.mucha.lib.api.DemoRepository
import com.mucha.lib.internal.DefaultDemoRepository
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
    fun demoRepository(categoryDao: CategoryDao, drinkDao: DrinkDao): DemoRepository =
        DefaultDemoRepository(categoryDao, drinkDao)
}
