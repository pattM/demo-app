package com.mucha.lib.internal.di

import android.app.Application
import com.mucha.lib.api.DemoApi
import com.mucha.lib.internal.di.modules.DatabaseModule
import com.mucha.lib.internal.di.modules.LibModule
import com.mucha.lib.internal.di.modules.ServiceModule
import com.mucha.lib.internal.work.DatabaseRefreshWorker
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component for a library module.
 */
@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        LibModule::class,
        ServiceModule::class,
    ]
)
internal interface LibComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): LibComponent
    }

    val demoApi: DemoApi

    // Workers
    fun inject(worker: DatabaseRefreshWorker)
}
