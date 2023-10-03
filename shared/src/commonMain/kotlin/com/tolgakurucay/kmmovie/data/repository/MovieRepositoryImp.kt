package com.tolgakurucay.kmmovie.data.repository

import com.tolgakurucay.kmmovie.data.mapper.toMovie
import com.tolgakurucay.kmmovie.data.remote.RemoteDataSource
import com.tolgakurucay.kmmovie.domain.model.Movie
import com.tolgakurucay.kmmovie.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDateSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDateSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDateSource.getMovie(movieId = movieId).toMovie()
    }
}