package com.example.test

import android.app.Application
import com.example.test.di.AppComponent
import com.example.test.di.DaggerAppComponent

class TestPikabuApplication: Application() {

    companion object {
        lateinit var instance: TestPikabuApplication
        private var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getAppComponent(): AppComponent {
        if (appComponent == null) {
            appComponent =
                    DaggerAppComponent.builder().build()
        }

        return appComponent as AppComponent
    }
}