package com.montway.movies

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.montway.movies.navigation.AppRoutes
import com.montway.movies.ui.movies.MoviesListRoute
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
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