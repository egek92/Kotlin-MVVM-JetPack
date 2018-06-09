package com.denwehrle.boilerplate.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 21:05.
 * Copyright (c) 2018. All rights reserved.
 */

@Module
class AppModule(val app: Application) {
  @Provides
  @Singleton
  fun provideApplication(): Application = app
}
