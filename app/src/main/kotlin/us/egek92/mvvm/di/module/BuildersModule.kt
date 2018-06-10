package us.egek92.mvvm.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import us.egek92.mvvm.ui.CryptoCurrencyActivity

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 21:04.
 * Copyright (c) 2018. All rights reserved.
 */
@Module
abstract class BuildersModule {
  @ContributesAndroidInjector
  abstract fun contributeCryptocurrenciesActivity(): CryptoCurrencyActivity
}