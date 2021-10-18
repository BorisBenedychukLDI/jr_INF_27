package com.fod.jooka.fyss.com

import android.app.Application
import com.fod.jooka.fyss.com.DaggerApplication09lio.ApplicationComponent09lio
import com.fod.jooka.fyss.com.DaggerApplication09lio.DaggerApplicationComponent09lio
import com.fod.jooka.fyss.com.DaggerApplication09lio.Setup09lio
import com.onesignal.OneSignal
import javax.inject.Inject

class Application09lio : Application() {

    @Inject lateinit var oneSignal: Setup09lio


    override fun onCreate() {
        super.onCreate()
        component09lio = DaggerApplicationComponent09lio.factory().create(
            "sp09lio",
            this,
            decodeStringB6409lio(CODED_ONESIGNAL_KEY)
        ).apply { inject09lio(this@Application09lio) }
    }

    companion object {
        private const val CODED_ONESIGNAL_KEY = "YjJjYjAwMTAtYjY2YS00YWMzLTg5NDgtYzA2ZGMzMTkyZWM5"
        lateinit var component09lio: ApplicationComponent09lio
    }
}