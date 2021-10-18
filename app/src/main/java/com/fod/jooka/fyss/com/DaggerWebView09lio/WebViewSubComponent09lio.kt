package com.fod.jooka.fyss.com.DaggerWebView09lio

import androidx.appcompat.app.AppCompatActivity
import com.fod.jooka.fyss.com.WebViewActivity09lio
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface WebViewSubComponent09lio {

    fun inject (webViewActivity09lio: WebViewActivity09lio)

    @Subcomponent.Factory
    interface Factory {
        fun create09lio (
            @BindsInstance activity09lio: AppCompatActivity
        ): WebViewSubComponent09lio
    }
}