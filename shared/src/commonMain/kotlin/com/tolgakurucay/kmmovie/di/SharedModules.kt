package com.tolgakurucay.kmmovie.di

import com.tolgakurucay.kmmovie.data.remote.MovieService
import com.tolgakurucay.kmmovie.data.remote.RemoteDataSource
import com.tolgakurucay.kmmovie.data.repository.MovieRepositoryImpl
import com.tolgakurucay.kmmovie.domain.repository.MovieRepository
import com.tolgakurucay.kmmovie.domain.usecase.GetMovieUseCase
import com.tolgakurucay.kmmovie.domain.usecase.GetMoviesUseCase
import com.tolgakurucay.kmmovie.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules