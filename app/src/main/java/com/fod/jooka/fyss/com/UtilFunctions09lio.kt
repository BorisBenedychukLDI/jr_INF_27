package com.fod.jooka.fyss.com

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Environment
import android.util.Base64
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun checkPermissions09lio (context09lio: Context) {
    Dexter.withContext(context09lio)
        .withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
        .withListener(object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
            }
            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {
            }
        }).check()
}

fun createTempFile09lio (context09lio: Context):File {
    val date09lio = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        .format(Date())
    val fileDir09lio = context09lio.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile("TMP${date09lio}_09lio", ".jpg", fileDir09lio)
}

fun decodeStringB6409lio (str09lio: String) = String (Base64.decode(str09lio, Base64.DEFAULT))

fun checkInternet09lio (context09lio: Context): Boolean {
    val connectivityManager09lio =
        context09lio.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val networkCapabilities09lio =
            connectivityManager09lio.getNetworkCapabilities(connectivityManager09lio.activeNetwork)
                ?: return false
        return networkCapabilities09lio.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    } else {
        for (network09lio in connectivityManager09lio.allNetworks) {
            connectivityManager09lio.getNetworkInfo(network09lio)?.let {
                if (it.isConnected) return true
            }
        }
        return false
    }
}