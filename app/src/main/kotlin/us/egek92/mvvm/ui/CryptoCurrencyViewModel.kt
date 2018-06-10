package us.egek92.mvvm.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import us.egek92.mvvm.data.model.CryptoCurrency
import us.egek92.mvvm.data.repository.CryptoCurrencyRepository
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:46.
 * Copyright (c) 2018. All rights reserved.
 */


class CryptoCurrencyViewModel @Inject constructor(
    private val cryptoCurrencyRepository: CryptoCurrencyRepository) : ViewModel() {

  var cryptocurrenciesResult: MutableLiveData<List<CryptoCurrency>> = MutableLiveData()
  var cryptocurrenciesError: MutableLiveData<String> = MutableLiveData()
  var cryptocurrenciesLoader: MutableLiveData<Boolean> = MutableLiveData()
  private lateinit var disposableObserver: DisposableObserver<List<CryptoCurrency>>

  fun cryptocurrenciesResult(): LiveData<List<CryptoCurrency>> {
    return cryptocurrenciesResult
  }

  fun cryptocurrenciesError(): LiveData<String> {
    return cryptocurrenciesError
  }

  fun cryptocurrenciesLoader(): LiveData<Boolean> {
    return cryptocurrenciesLoader
  }

  fun loadCryptocurrencies(limit: Int, offset: Int) {

    disposableObserver = object : DisposableObserver<List<CryptoCurrency>>() {
      override fun onComplete() {

      }

      override fun onNext(cryptoCurrencies: List<CryptoCurrency>) {
        cryptocurrenciesResult.postValue(cryptoCurrencies)
        cryptocurrenciesLoader.postValue(false)
      }

      override fun onError(e: Throwable) {
        cryptocurrenciesError.postValue(e.message)
        cryptocurrenciesLoader.postValue(false)
      }
    }

    cryptoCurrencyRepository.getCryptocurrencies(limit, offset)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .debounce(400, MILLISECONDS)
        .subscribe(disposableObserver)
  }

  fun disposeElements() {
    if (!disposableObserver.isDisposed) disposableObserver.dispose()
  }

}