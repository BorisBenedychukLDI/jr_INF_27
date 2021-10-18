package com.fod.jooka.fyss.com.WebViewClasses09lio

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView

class WebView09lio(context09lio: Context, attributeSet09lio: AttributeSet): WebView(context09lio, attributeSet09lio) {
    init {
        scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        settings.run {
            loadWithOverviewMode = true
            displayZoomControls = false
            useWideViewPort = true
            mediaPlaybackRequiresUserGesture = false
            javaScriptEnabled = true
            loadsImagesAutomatically = true
            displayZoomControls = false
            domStorageEnabled = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            builtInZoomControls = true
        }
    }
}