package com.montway.movies.di

import com.montway.movies.ui.moviedetail.MovieDetailViewModel
import com.montway.movies.ui.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
    viewModel { MovieDetailViewModel(get(), get()) }
}