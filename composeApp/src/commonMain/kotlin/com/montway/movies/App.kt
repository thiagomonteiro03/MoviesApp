package com.montway.movies

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.montway.movies.di.dataModule
import com.montway.movies.di.networkModule
import com.montway.movies.di.viewModelModule
import com.montway.movies.navigation.AppRoutes
import com.montway.movies.ui.movies.MoviesListRoute
import com.montway.movies.ui.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(networkModule, dataModule, viewModelModule, )
        }
    ) {
        MoviesAppTheme {
            val navController = rememberNavController()
            NavHost(navController, startDestination = AppRoutes.MoviesList){
                composable<AppRoutes.MoviesList> {
                    MoviesListRoute()
                }

                composable<AppRoutes.MovieDetails> {
//                MovieDetailsScreen()
                }
            }
        }
    }
}