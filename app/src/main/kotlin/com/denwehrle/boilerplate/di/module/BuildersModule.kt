package com.denwehrle.boilerplate.di.module

import com.denwehrle.boilerplate.ui.CryptocurrenciesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 21:04.
 * Copyright (c) 2018. All rights reserved.
 */
@Module
abstract class BuildersModule {
  @ContributesAndroidInjector
  abstract fun contributeCryptocurrenciesActivity(): CryptocurrenciesActivity
}