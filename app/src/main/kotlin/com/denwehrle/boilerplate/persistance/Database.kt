package com.denwehrle.boilerplate.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.denwehrle.boilerplate.data.Cryptocurrency

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 23:59.
 * Copyright (c) 2018. All rights reserved.
 */
@Database(entities = [(Cryptocurrency::class)], version = 1)
abstract class Database : RoomDatabase() {
  abstract fun cryptocurrenciesDao(): CryptocurrenciesDao
}