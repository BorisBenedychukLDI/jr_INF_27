package com.fod.jooka.fyss.com.DaggerApplication09lio

import android.app.Application
import android.content.Context
import com.fod.jooka.fyss.com.DaggerSplash09lio.SplashSubComponent
import com.fod.jooka.fyss.com.DaggerWebView09lio.WebViewSubComponent09lio
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component (modules = [SPModule09lio::class])
interface ApplicationComponent09lio {

    fun splashSC09lio (): SplashSubComponent
    fun webSC09lio (): WebViewSubComponent09lio.Factory

    fun inject09lio (application: Application)

    @Component.Factory
    interface Factory {
        fun create (
            @BindsInstance @Named ("tag09lio") tag09lio: String,
            @BindsInstance context09lio: Context,
        ): ApplicationComponent09lio
    }
}