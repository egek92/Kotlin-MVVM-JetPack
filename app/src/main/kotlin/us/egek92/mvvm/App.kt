package us.egek92.mvvm

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import us.egek.mvvm.BuildConfig
import us.egek92.mvvm.di.component.DaggerAppComponent
import us.egek92.mvvm.di.module.AppModule
import us.egek92.mvvm.di.module.NetModule
import javax.inject.Inject


/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:06.
 * Copyright (c) 2018. All rights reserved.
 */
class App : Application(), HasActivityInjector {
  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    @Suppress("DEPRECATION")
    DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .netModule(NetModule(BuildConfig.URL))
        .build()
        .inject(this)

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
      Stetho.initializeWithDefaults(this)
    }

    if (LeakCanary.isInAnalyzerProcess(this)) {
      return
    }
    LeakCanary.install(this)


  }

  override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}