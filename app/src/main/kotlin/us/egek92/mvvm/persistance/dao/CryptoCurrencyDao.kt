package us.egek92.mvvm.persistance.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import us.egek92.mvvm.data.model.CryptoCurrency

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 23:58.
 * Copyright (c) 2018. All rights reserved.
 */
@Dao
interface CryptoCurrencyDao {

  @Query("SELECT * FROM cryptoCurrencies ORDER BY rank limit :limit offset :offset")
  fun queryCryptocurrencies(limit: Int, offset: Int): Single<List<CryptoCurrency>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCryptocurrency(cryptoCurrency: CryptoCurrency)

  @Insert(
      onConflict = OnConflictStrategy.REPLACE
  )
  fun insertAllCryptocurrencies(cryptoCurrencies: List<CryptoCurrency>)
}