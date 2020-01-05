package com.example.test.data.network

import com.example.test.BuildConfig
import com.example.test.TestPikabuApplication
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    var apiService: IApiService
        private set

    init {
        apiService = createRetrofit(BuildConfig.SERVER_URL, getHttpClient()).create(IApiService::class.java)
    }

    private fun createRetrofit(hostUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonManager.instance))
                .baseUrl(hostUrl)
                .build()
    }

    private fun getHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.interceptors().add(ChuckInterceptor(TestPikabuApplication.instance))

        return httpClient.build()
    }
}