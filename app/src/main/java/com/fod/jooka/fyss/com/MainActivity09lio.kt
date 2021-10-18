package com.fod.jooka.fyss.com

import android.animation.ValueAnimator
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.lifecycle.lifecycleScope
import com.fod.jooka.fyss.com.databinding.ActivityMain09lioBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity09lio : AppCompatActivity() {
    companion object {
        private val CODED_BINOM_KEY = "aHR0cHM6Ly9qb29rYS5qb3ljYXMuY2x1Yi9jbGljay5waHA/a2V5PXhleTF5dHpscmViajFhZHR5N2h2"
    }
    private lateinit var sharedPreferences09lio: SharedPreferences
    private lateinit var binding09lio: ActivityMain09lioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding09lio = ActivityMain09lioBinding.inflate(layoutInflater)
        setContentView(binding09lio.root)
        sharedPreferences09lio = Application09lio.component09lio.splashSC09lio().sharedPreferences09lio().apply {
            getString("Last_Page_09lio", null)?.let {
                startActivity(Intent(this@MainActivity09lio, WebViewActivity09lio::class.java))
                finish()
            }
        }
        sharedPreferences09lio.edit().putString("Web_Url_09lio",decodeStringB6409lio(CODED_BINOM_KEY)).apply()
        binding09lio.b09lio.isClickable = false
        lifecycleScope.launch {
            ValueAnimator.ofFloat(0f, 1f).run {
                duration = 5000
                addUpdateListener {
                    binding09lio.lottieMain09lio.progress = it.animatedValue.toString().toFloat()
                }
                doOnEnd {
                    binding09lio.pb09lio.animate().alpha(0f)
                    binding09lio.lottieMain09lio.setOnClickListener {
                        startActivity(Intent(this@MainActivity09lio, WebViewActivity09lio::class.java))
                        finish()
                    }
                }
                start()
            }

        }

    }
}