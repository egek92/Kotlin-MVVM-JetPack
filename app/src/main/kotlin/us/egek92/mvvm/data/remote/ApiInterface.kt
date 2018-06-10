package us.egek92.mvvm.data.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import us.egek92.mvvm.data.model.CryptoCurrency

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:14.
 * Copyright (c) 2018. All rights reserved.
 */
interface ApiInterface {

  @GET("ticker/")
  fun getCryptocurrencies(@Query("start") start: String): Observable<List<CryptoCurrency>>
}