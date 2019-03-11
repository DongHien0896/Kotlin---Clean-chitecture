package com.framgia.trainingclean.presentation.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun Context.checkNetworkConnection(flagConectivity: String): Boolean {
    val conectivityManager = getSystemService(flagConectivity) as ConnectivityManager
    val networkInfo: NetworkInfo? = conectivityManager.activeNetworkInfo
    return if (networkInfo == null) {
        false
    } else networkInfo.isConnected
}