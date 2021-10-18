package com.fod.jooka.fyss.com.DaggerApplication09lio

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import com.onesignal.OneSignal
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class OSModule09lio {


    @Provides
    fun sharedPreferences09lio (context09lio: Context, @Named ("tag09lio") tag09lio: String): SharedPreferences = context09lio.getSharedPreferences(tag09lio, MODE_PRIVATE)

    @Provides
    fun onesignal09lio (context09lio: Context, @Named ("osKeyDecoded09lio") osKeyDecoded09lio : String): Setup09lio {
        Log.d("TEST_OS", "Here")
        OneSignal.initWithContext(context09lio)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.setAppId(osKeyDecoded09lio)
        return Setup09lio()
    }
}