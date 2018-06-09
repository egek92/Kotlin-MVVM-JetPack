package com.denwehrle.boilerplate

import android.app.Activity
import android.app.Application
import com.denwehrle.boilerplate.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author Dennis Wehrle
 */

class CryptocurrencyApplication : Application(), HasActivityInjector {
  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}