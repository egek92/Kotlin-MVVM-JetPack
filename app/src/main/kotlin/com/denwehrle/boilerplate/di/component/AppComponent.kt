package com.denwehrle.boilerplate.di.component

import android.app.Application
import com.denwehrle.boilerplate.di.module.AppModule
import com.denwehrle.boilerplate.di.module.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 21:07.
 * Copyright (c) 2018. All rights reserved.
 */
@Singleton
@Component(
    modules = [(AndroidInjectionModule::class), (BuildersModule::class), (AppModule::class)]
)
interface AppComponent {
  fun inject(app: Application)
}