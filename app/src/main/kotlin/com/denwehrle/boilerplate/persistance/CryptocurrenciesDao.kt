package com.denwehrle.boilerplate.persistance

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.denwehrle.boilerplate.data.Cryptocurrency

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 23:58.
 * Copyright (c) 2018. All rights reserved.
 */
@Dao
interface CryptocurrenciesDao {

  @Query("SELECT * FROM cryptocurrency")
  fun queryCryptocurrencies(): LiveData<List<Cryptocurrency>>

  @Insert(
      onConflict = OnConflictStrategy.REPLACE
  )
  fun insertCryptocurrency(cryptocurrency: Cryptocurrency)
}