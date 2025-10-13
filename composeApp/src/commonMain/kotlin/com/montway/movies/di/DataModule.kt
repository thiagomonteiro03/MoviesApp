package com.montway.movies.di

import com.montway.movies.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    factory { MoviesRepository(get()) }
}