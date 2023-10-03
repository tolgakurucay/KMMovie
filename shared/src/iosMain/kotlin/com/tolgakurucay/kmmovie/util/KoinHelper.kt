package com.tolgakurucay.kmmovie.util

import com.tolgakurucay.kmmovie.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}