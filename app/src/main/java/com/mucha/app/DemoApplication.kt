package com.mucha.app

import android.app.Application
import com.mucha.lib.DemoLib

/**
 *
 */
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DemoLib.init(this)
    }
}
