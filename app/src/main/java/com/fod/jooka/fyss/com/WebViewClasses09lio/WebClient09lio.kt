package com.fod.jooka.fyss.com.WebViewClasses09lio

import android.content.Intent
import android.content.SharedPreferences
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import javax.inject.Inject

class WebClient09lio  @Inject constructor(private val sharedPreferences09lio: SharedPreferences) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view09lio: WebView?, request09lio: WebResourceRequest?): Boolean {
        val prohibitedLinks09lio = listOf("facebook","twitter")
        val modifiedLinks09lio = listOf ("mailto:","tel:")
        return when {
            modifiedLinks09lio.find { request09lio?.url.toString().startsWith(it) } != null -> {
                view09lio?.context?.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        request09lio?.url
                    )
                )
                true
            }
            prohibitedLinks09lio.find { request09lio?.url.toString().contains(it) } != null ->
                true
            else -> false
        }
    }

    override fun onPageFinished(view09lio: WebView?, url09lio: String?) {
        sharedPreferences09lio.edit().putString("Last_Page_09lio", url09lio?: return).apply()
        super.onPageFinished(view09lio, url09lio)
    }

    override fun onReceivedSslError(view09lio: WebView?, handler09lio: SslErrorHandler?, error09lio: SslError?) {
        handler09lio?.proceed()
        super.onReceivedSslError(view09lio, handler09lio, error09lio)
    }
}