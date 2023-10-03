package com.tolgakurucay.kmmovie.data.mapper

import com.tolgakurucay.kmmovie.data.remote.MovieRemote
import com.tolgakurucay.kmmovie.domain.model.Movie

internal fun MovieRemote.toMovie(): Movie = Movie(
    id = id,
    title = title,
    description = overview,
    imageUrl = getImageUrl(posterImage),
    releaseDate = releaseDate
)

private fun getImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"