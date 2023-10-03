package com.tolgakurucay.kmmovie.data.remote

import com.tolgakurucay.kmmovie.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {

    suspend fun getMovies(page: Int) = withContext(dispatcher.io){
        apiService.getMovies(page = page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io){
        apiService.getMovie(movieId = movieId)
    }
}