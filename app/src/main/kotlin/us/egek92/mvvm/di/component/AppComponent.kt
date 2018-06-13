package us.egek92.mvvm.di.component

import us.egek92.mvvm.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import us.egek92.mvvm.di.module.AppModule
import us.egek92.mvvm.di.module.BuildersModule
import us.egek92.mvvm.di.module.NetModule
import javax.inject.Singleton


/**
 * Created by Ege Kuzubasioglu on 9.06.2018 at 21:07.
 * Copyright (c) 2018. All rights reserved.
 */
@Singleton
@Component(
    modules = [(AndroidInjectionModule::class), (BuildersModule::class), (AppModule::class), (NetModule::class)]
)
interface AppComponent {
  fun inject(app: App)
}
