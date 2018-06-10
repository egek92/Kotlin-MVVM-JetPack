package us.egek92.mvvm.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import javax.inject.Inject

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:57.
 * Copyright (c) 2018. All rights reserved.
 */
class Utils @Inject constructor(private val context: Context) {

  fun isConnectedToInternet(): Boolean {
    val connectivity = context.getSystemService(
        Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = connectivity.allNetworkInfo
    if (info != null)
      for (i in info.indices)
        if (info[i].state == NetworkInfo.State.CONNECTED) {
          return true
        }
    return false
  }
}