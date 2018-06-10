package us.egek92.mvvm.persistance.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import us.egek92.mvvm.data.model.CryptoCurrency
import us.egek92.mvvm.persistance.dao.CryptoCurrencyDao

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 23:59.
 * Copyright (c) 2018. All rights reserved.
 */
@Database(entities = [(CryptoCurrency::class)], version = 1)
abstract class Database : RoomDatabase() {
  abstract fun cryptocurrenciesDao(): CryptoCurrencyDao
}