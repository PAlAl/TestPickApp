package com.example.test.di

import com.example.test.data.network.ApiFactory
import com.example.test.data.network.IApiService
import com.example.test.domain.global.managers.AppSchedulersManager
import com.example.test.domain.global.managers.ISchedulersManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideApiService(): IApiService = ApiFactory.apiService

    @Singleton
    @Provides
    fun provideSchedulersProvider(): ISchedulersManager = AppSchedulersManager()
}