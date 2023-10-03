package com.tolgakurucay.kmmovie.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//List
//https://api.themoviedb.org/3/movie/popular?language=en-US&api_key=064efb69133e225b30acafcb8f4d29e4&page=1
//Detail
//https://api.themoviedb.org/3/movie/603692?api_key=064efb69133e225b30acafcb8f4d29e4&language=en-US


private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "064efb69133e225b30acafcb8f4d29e4"

//Internal keyword provides us to available class in the same module
internal abstract class KtorApi {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(json = Json {
                // this parameter do process like mapping
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }


    fun HttpRequestBuilder.pathUrl(pathDirectory: String) {
        url {
            takeFrom(BASE_URL)
            path("3",pathDirectory)
            parameter("api_key", API_KEY)
        }
    }

}