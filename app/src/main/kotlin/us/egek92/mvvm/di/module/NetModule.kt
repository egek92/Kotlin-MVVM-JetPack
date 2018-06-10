package us.egek92.mvvm.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.MoshiConverterFactory
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import us.egek92.mvvm.data.remote.ApiInterface
import javax.inject.Singleton

/**
 * Created by Ege Kuzubasioglu on 10.06.2018 at 00:42.
 * Copyright (c) 2018. All rights reserved.
 */

@Module
class NetModule(private val baseUrl: String) {

  @Provides
  @Singleton
  fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

  @Provides
  @Singleton
  fun providesMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

  @Provides
  @Singleton
  fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Builder().client(okHttpClient).baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @Provides
  @Singleton
  fun providesApiInterface(retrofit: Retrofit): ApiInterface = retrofit.create(
      ApiInterface::class.java)
}