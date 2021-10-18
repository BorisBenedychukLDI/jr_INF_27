package com.fod.jooka.fyss.com.DaggerApplication09lio

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class SPModule09lio {

    @Provides
    @Singleton
    fun sharedPreferences09lio (context09lio: Context, @Named ("tag09lio") tag09lio: String): SharedPreferences {
        return context09lio.getSharedPreferences(tag09lio, MODE_PRIVATE)
    }
}