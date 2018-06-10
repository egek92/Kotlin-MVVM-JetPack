package us.egek92.mvvm.data.repository

import io.reactivex.Observable
import timber.log.Timber
import us.egek92.mvvm.data.model.CryptoCurrency
import us.egek92.mvvm.data.remote.ApiInterface
import us.egek92.mvvm.persistance.dao.CryptoCurrencyDao
import us.egek92.mvvm.utils.Constants
import us.egek92.mvvm.utils.Utils
import javax.inject.Inject

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:37.
 * Copyright (c) 2018. All rights reserved.
 */
class CryptoCurrencyRepository @Inject constructor(private val apiInterface: ApiInterface,
    private val cryptoCurrencyDao: CryptoCurrencyDao, private val utils: Utils) {

  fun getCryptocurrencies(limit: Int, offset: Int): Observable<List<CryptoCurrency>> {
    val hasConnection = utils.isConnectedToInternet()
    var observableFromApi: Observable<List<CryptoCurrency>>? = null
    if (hasConnection) {
      observableFromApi = getCryptocurrenciesFromApi()
    }
    val observableFromDb = getCryptocurrenciesFromDb(limit, offset)

    return if (hasConnection) Observable.concatArrayEager(observableFromApi, observableFromDb)
    else observableFromDb
  }

  private fun getCryptocurrenciesFromApi(): Observable<List<CryptoCurrency>> {
    return apiInterface.getCryptocurrencies(Constants.START_ZERO_VALUE)
        .doOnNext {
          Timber.e(it.size.toString())
          for (item in it) {
            cryptoCurrencyDao.insertCryptocurrency(item)
          }
        }
  }

  private fun getCryptocurrenciesFromDb(limit: Int, offset: Int): Observable<List<CryptoCurrency>> {
    return cryptoCurrencyDao.queryCryptocurrencies(limit, offset)
        .toObservable()
        .doOnNext {
          Timber.e(it.size.toString())
        }
  }
}