package com.tolgakurucay.kmmovie.domain.usecase

import com.tolgakurucay.kmmovie.domain.model.Movie
import com.tolgakurucay.kmmovie.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieId: Int): Movie {
        return repository.getMovie(movieId = movieId)
    }
}