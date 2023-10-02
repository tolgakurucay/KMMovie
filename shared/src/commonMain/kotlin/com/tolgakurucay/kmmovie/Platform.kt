package com.tolgakurucay.kmmovie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform