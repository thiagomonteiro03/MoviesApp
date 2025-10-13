package com.montway.movies.di

import com.montway.movies.data.network.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
}