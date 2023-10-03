package com.tolgakurucay.kmmovie.android

import android.app.Application
import com.tolgakurucay.kmmovie.android.di.appModule
import com.tolgakurucay.kmmovie.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}