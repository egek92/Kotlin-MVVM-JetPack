package com.denwehrle.boilerplate.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.denwehrle.boilerplate.R
import com.denwehrle.boilerplate.data.ApiClient
import com.denwehrle.boilerplate.data.ApiInterface
import com.denwehrle.boilerplate.data.Cryptocurrency
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 23:51.
 * Copyright (c) 2018. All rights reserved.
 */


class CryptocurrenciesActivity : AppCompatActivity() {

  val compositeDisposable: CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_crypto_currency)


    showCryptocurrencies()
  }

  private fun showCryptocurrencies() {
    val cryptocurrenciesResponse = getCryptocurrencies()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())

    val disposableObserver =
        cryptocurrenciesResponse.subscribeWith(object : DisposableObserver<List<Cryptocurrency>>() {
          override fun onComplete() {
          }

          override fun onNext(cryptocurrencies: List<Cryptocurrency>) {
            val listSize = cryptocurrencies.size
            Timber.e("$listSize items are available")
          }

          override fun onError(e: Throwable) {
            Timber.e(e.message)
          }

        })

    compositeDisposable.addAll(disposableObserver)

  }

  private fun getCryptocurrencies(): Observable<List<Cryptocurrency>> {
    val retrofit = ApiClient.getClient()
    val apiInterface = retrofit.create(ApiInterface::class.java)
    return apiInterface.getCryptocurrencies("0")
  }


  override fun onDestroy() {
    if (!compositeDisposable.isDisposed) {
      compositeDisposable.dispose()
    }
    super.onDestroy()
  }
}