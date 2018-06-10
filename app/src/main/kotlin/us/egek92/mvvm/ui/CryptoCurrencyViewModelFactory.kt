package us.egek92.mvvm.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:47.
 * Copyright (c) 2018. All rights reserved.
 */

class CryptoCurrencyViewModelFactory @Inject constructor(
    private val cryptoCurrencyViewModel: CryptoCurrencyViewModel) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(CryptoCurrencyViewModel::class.java)) {
      return cryptoCurrencyViewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}