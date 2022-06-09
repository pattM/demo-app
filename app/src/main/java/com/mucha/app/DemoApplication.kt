package com.mucha.app

import android.app.Application
import com.mucha.lib.DemoLib
import dagger.hilt.android.HiltAndroidApp

/**
 * Main [Application] implementation.
 */
@HiltAndroidApp
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DemoLib.init(this)
    }
}
