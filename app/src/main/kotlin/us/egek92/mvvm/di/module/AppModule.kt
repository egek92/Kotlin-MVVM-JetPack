package us.egek92.mvvm.di.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import dagger.Module
import dagger.Provides
import us.egek92.mvvm.persistance.dao.CryptoCurrencyDao
import us.egek92.mvvm.persistance.local.Database
import us.egek92.mvvm.ui.CryptoCurrencyViewModelFactory
import us.egek92.mvvm.utils.Constants
import us.egek92.mvvm.utils.Utils
import javax.inject.Singleton

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 21:05.
 * Copyright (c) 2018. All rights reserved.
 */

@Module
class AppModule(private val app: Application) {
  companion object {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
      override fun migrate(database: SupportSQLiteDatabase) {
        // Change the table name to the correct one
        database.execSQL("ALTER TABLE cryptocurrency RENAME TO cryptoCurrencies")
      }
    }
  }

  @Provides
  @Singleton
  fun provideApplication(): Application = app

  @Provides
  @Singleton
  fun provideCryptocurrenciesDatabase(app: Application): Database = Room.databaseBuilder(app,
      Database::class.java, Constants.DATABASE_NAME)
      /*.addMigrations(MIGRATION_1_2)*/
      .fallbackToDestructiveMigration()
      .build()

  @Provides
  @Singleton
  fun provideCryptocurrenciesDao(
      database: Database): CryptoCurrencyDao = database.cryptocurrenciesDao()

  @Provides
  @Singleton
  fun provideCryptocurrenciesViewModelFactory(
      factory: CryptoCurrencyViewModelFactory): ViewModelProvider.Factory = factory

  @Provides
  @Singleton
  fun provideUtils(): Utils = Utils(app)
}
