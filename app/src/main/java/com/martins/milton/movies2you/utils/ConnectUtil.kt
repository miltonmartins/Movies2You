package com.martins.milton.movies2you.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object ConnectUtil {
    fun isConnected(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}