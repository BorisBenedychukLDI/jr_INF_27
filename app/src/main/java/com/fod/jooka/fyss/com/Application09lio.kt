package com.fod.jooka.fyss.com

import android.app.Application
import com.fod.jooka.fyss.com.DaggerApplication09lio.ApplicationComponent09lio
import com.fod.jooka.fyss.com.DaggerApplication09lio.DaggerApplicationComponent09lio
import com.onesignal.OneSignal

class Application09lio : Application() {



    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.setAppId(decodeStringB6409lio(CODED_ONESIGNAL_KEY_09lio))
        component09lio = DaggerApplicationComponent09lio.factory().create(
            "sp09lio",
            this
        ).apply { inject09lio(this@Application09lio) }
    }

    companion object {
        private const val CODED_ONESIGNAL_KEY_09lio = "YjJjYjAwMTAtYjY2YS00YWMzLTg5NDgtYzA2ZGMzMTkyZWM5"
        lateinit var component09lio: ApplicationComponent09lio
    }
}