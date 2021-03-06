package com.mucha.lib.di

import com.mucha.lib.DemoLib
import com.mucha.lib.api.DemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger module to provide/expose library dependencies to the application.
 */
@Module
@InstallIn(SingletonComponent::class)
object DemoLibModule {

    @Provides
    @Singleton
    fun demoRepository(): DemoRepository = DemoLib.component.demoRepository
}
