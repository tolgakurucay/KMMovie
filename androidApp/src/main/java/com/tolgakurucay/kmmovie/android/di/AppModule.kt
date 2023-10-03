package com.tolgakurucay.kmmovie.android.di

import com.tolgakurucay.kmmovie.android.detail.DetailViewModel
import com.tolgakurucay.kmmovie.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}