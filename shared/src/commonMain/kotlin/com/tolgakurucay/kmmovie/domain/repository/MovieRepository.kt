package com.tolgakurucay.kmmovie.domain.repository

import com.tolgakurucay.kmmovie.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}