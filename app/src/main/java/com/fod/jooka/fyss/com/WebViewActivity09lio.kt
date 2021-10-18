package com.fod.jooka.fyss.com

import android.animation.FloatEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.lifecycle.lifecycleScope
import com.fod.jooka.fyss.com.WebViewClasses09lio.WebChromeClient09lio
import com.fod.jooka.fyss.com.WebViewClasses09lio.WebClient09lio
import com.fod.jooka.fyss.com.WebViewClasses09lio.*
import com.fod.jooka.fyss.com.databinding.ActivityWebViewActivity09lioBinding
import kotlinx.coroutines.*
import javax.inject.Inject

class WebViewActivity09lio : AppCompatActivity() {

    @Inject
    lateinit var webClient09lio: WebClient09lio

    @Inject
    lateinit var webChromeClient09lio: WebChromeClient09lio

    @Inject
    lateinit var sharedPreferences09lio: SharedPreferences

    private lateinit var binding09lio: ActivityWebViewActivity09lioBinding
    private var job09lio: Job? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding09lio = ActivityWebViewActivity09lioBinding.inflate(layoutInflater)
        setContentView(binding09lio.root)
        Application09lio.component09lio.webSC09lio().create09lio(this).inject(this)
        binding09lio.wv09lio.run {
            webChromeClient = webChromeClient09lio
            webViewClient = webClient09lio
        }
        binding09lio.srl09lio.setOnRefreshListener {
            binding09lio.wv09lio.run { loadUrl(url ?: return@setOnRefreshListener) }
            binding09lio.srl09lio.isRefreshing = false
        }
        sharedPreferences09lio.getString("Last_Page_09lio", null)?.let {
            binding09lio.wv09lio.loadUrl(it)
            return
        }
        binding09lio.wv09lio.loadUrl(
            sharedPreferences09lio.getString("Web_Url_09lio", null) ?: return
        )
    }



    private fun startChecking09lio () {
        lifecycleScope.launch {
            while (isActive) {
                delay(500)
                if (!checkInternet09lio(this@WebViewActivity09lio)) {
                    animate09lio()
                    cancel()
                }
            }
        }
    }

    override fun onResume() {
        startChecking09lio()
        super.onResume()
    }

    override fun onActivityResult(requestCode09lio: Int, resultCode09lio: Int, data09lio: Intent?) {
        if (filepathCB09lio != null) {
            val uriResult09lio =
                if (data09lio == null || resultCode09lio != RESULT_OK) null else data09lio.data
            if (uriResult09lio != null) {
                filepathCB09lio?.onReceiveValue(arrayOf(uriResult09lio))
            } else {
                filepathCB09lio?.onReceiveValue(arrayOf(uriView09lio))
            }
            filepathCB09lio = null
        }
        super.onActivityResult(requestCode09lio, resultCode09lio, data09lio)
    }

    override fun onBackPressed() =
        if (binding09lio.wv09lio.canGoBack()) binding09lio.wv09lio.goBack() else super.onBackPressed()

    private fun animate09lio() {
        lifecycleScope.launch {
            binding09lio.srl09lio.animate().alpha(0f)
            binding09lio.wv09lio.animate().alpha(0f)
            ValueAnimator.ofFloat(0f, 1f).run {
                duration = 2000
                addUpdateListener {
                    binding09lio.lottieWv09lio.progress = it.animatedValue.toString().toFloat()
                }
                start()
                doOnEnd {
                    binding09lio.srl09lio.visibility = View.GONE
                }
            }
            delay(2000)
            binding09lio.bWv09lio.setOnClickListener {
                if (checkInternet09lio(this@WebViewActivity09lio)) {
                    ValueAnimator.ofFloat(1f, 0f).run {
                        duration = 1000
                        addUpdateListener {
                            binding09lio.lottieWv09lio.progress =
                                it.animatedValue.toString().toFloat()
                        }
                        doOnEnd {
                            binding09lio.srl09lio.visibility = View.VISIBLE
                            binding09lio.srl09lio.animate().alpha(1f)
                            binding09lio.wv09lio.animate().alpha(1f)
                            startChecking09lio()
                        }
                        start()
                    }
                } else {
                    ObjectAnimator.ofFloat(binding09lio.bWv09lio, View.TRANSLATION_X, 0f, 5f).run {
                        duration = 100
                        doOnEnd {
                            ObjectAnimator.ofFloat(
                                binding09lio.bWv09lio,
                                View.TRANSLATION_X,
                                5f,
                                -5f
                            ).run {
                                duration = 50
                                repeatCount = 10
                                doOnEnd {
                                    binding09lio.bWv09lio.animate().translationX(0f)
                                }
                                start()
                            }
                        }
                        start()
                    }
                }
            }
        }
    }
}