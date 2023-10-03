package com.tolgakurucay.kmmovie.data.remote

@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    val results: List<MovieRemote>
)