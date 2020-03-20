package com.example.test.di

import android.content.Context
import com.example.test.BuildConfig
import com.example.test.data.network.GsonManager
import com.example.test.data.network.IApiService
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetSubModule {

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): IApiService = retrofit.create(IApiService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named("SERVER_URL") url: String): Retrofit =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GsonManager.instance))
                    .baseUrl(url)
                    .build()

    @Singleton
    @Provides
    fun provideOkHttp(context: Context): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.CHUCK_ENABLE)
            okHttpBuilder.addInterceptor(ChuckInterceptor(context))

        return okHttpBuilder.build()
    }
}