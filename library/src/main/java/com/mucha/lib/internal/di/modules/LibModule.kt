package com.mucha.lib.internal.di.modules

import com.mucha.lib.api.DemoApi
import com.mucha.lib.internal.DefaultDemoApi
import com.mucha.lib.internal.db.dao.CategoryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Default library Dagger module.
 */
@Module
internal class LibModule {

    @Provides
    @Singleton
    fun demoApi(categoryDao: CategoryDao): DemoApi = DefaultDemoApi(categoryDao)
}
