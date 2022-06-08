package com.mucha.lib

import android.app.Application
import com.mucha.lib.DemoLib.init
import com.mucha.lib.api.DemoApi
import com.mucha.lib.internal.di.DaggerLibComponent
import com.mucha.lib.internal.di.LibComponent
import com.mucha.lib.internal.work.DatabaseRefreshWorker

/**
 * Main entry point to the module. Call [init] before accessing any properties.
 */
object DemoLib {

    /**
     * Dagger component of the library module.
     */
    internal lateinit var component: LibComponent
        private set

    /**
     * Instance of [DemoApi] implementation.
     */
    val demoApi: DemoApi
        get() = component.demoApi

    /**
     * Initializes the module. This **MUST** be called prior to using the library module.
     *
     * @param application The instance of [Application].
     */
    fun init(application: Application) {
        if (::component.isInitialized) {
            return
        }
        component =
            DaggerLibComponent.builder()
                .application(application)
                .build()

        DatabaseRefreshWorker.enqueue(application)
    }
}
