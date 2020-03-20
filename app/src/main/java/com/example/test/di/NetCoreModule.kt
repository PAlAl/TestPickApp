package com.example.test.di

import com.example.test.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [NetSubModule::class])
class NetCoreModule {

    @Provides
    @Named("SERVER_URL")
    fun provideServerUrl(): String = BuildConfig.SERVER_URL
}