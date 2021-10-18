package com.fod.jooka.fyss.com.WebViewClasses09lio

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.fod.jooka.fyss.com.checkPermissions09lio
import com.fod.jooka.fyss.com.createTempFile09lio
import javax.inject.Inject

class WebChromeClient09lio @Inject constructor(private val activity09lio: AppCompatActivity) : WebChromeClient() {

    override fun onShowFileChooser(
        webView09lio: WebView?,
        filePathCallback09lioin: ValueCallback<Array<Uri>>?,
        fileChooserParams09lio: FileChooserParams?
    ): Boolean {
        checkPermissions09lio(activity09lio)
        filepathCB09lio = filePathCallback09lioin
        val captureIntent09lio = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (captureIntent09lio.resolveActivity(activity09lio.packageManager) != null) {
            val providedFile09lio = createTempFile09lio(activity09lio)
            uriView09lio = FileProvider.getUriForFile(
                activity09lio,
                "${activity09lio.applicationContext.packageName}.provider",
                providedFile09lio
            )
            captureIntent09lio.run {
                putExtra(MediaStore.EXTRA_OUTPUT, uriView09lio)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            val actionIntent09lio = Intent(Intent.ACTION_GET_CONTENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/*"
            }
            val intentChooser09lio = Intent(Intent.ACTION_CHOOSER).apply {
                putExtra(Intent.EXTRA_INTENT, captureIntent09lio)
                putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(actionIntent09lio))
            }
            activity09lio.startActivityForResult(intentChooser09lio, 0)
            return true

        }
        return super.onShowFileChooser(webView09lio, filePathCallback09lioin, fileChooserParams09lio)
    }
}