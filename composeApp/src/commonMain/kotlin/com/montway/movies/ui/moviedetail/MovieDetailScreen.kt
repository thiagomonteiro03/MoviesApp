package com.montway.movies.ui.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.montway.movies.domain.model.movie1
import com.montway.movies.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.movie_detail_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieDetailRoute(
    viewModel: MovieDetailViewModel = koinViewModel(),
    navigateBack: () -> Unit,
) {
    val movieDetailState by viewModel.movieDetailState.collectAsStateWithLifecycle()
    MovieDetailScreen(
        movieDetailState = movieDetailState,
        onNavigationIconClick = navigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    movieDetailState: MovieDetailViewModel.MovieDetailState,
    onNavigationIconClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(Res.string.movie_detail_title)
                    )
                },
                navigationIcon = {
                    Surface(
                        modifier = Modifier.padding(start = 12.dp),
                        shape = MaterialTheme.shapes.small
                    ) {
                        IconButton(
                            onClick = onNavigationIconClick,
                            modifier = Modifier
                                .size(32.dp)
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                                contentDescription = null,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when(movieDetailState) {
                MovieDetailViewModel.MovieDetailState.Loading -> {
                    CircularProgressIndicator()
                }
                is MovieDetailViewModel.MovieDetailState.Success -> {
                    MovieDetailContent(
                        movie = movieDetailState.movie,
                        onWatchTrailerClick = { key ->
                            println("Abre vídeo com key: $key")
                        }
                    )
                }
                is MovieDetailViewModel.MovieDetailState.Error -> {
                    Text(
                        text = movieDetailState.message,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MovieDetailPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movieDetailState = MovieDetailViewModel.MovieDetailState.Success(movie1),
            onNavigationIconClick = {}
        )
    }
}

@Preview
@Composable
private fun LoadingMovieDetailPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movieDetailState = MovieDetailViewModel.MovieDetailState.Loading,
            onNavigationIconClick = {}
        )
    }
}

@Preview
@Composable
private fun ErrorMovieDetailPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movieDetailState = MovieDetailViewModel.MovieDetailState.Error("Network error"),
            onNavigationIconClick = {}
        )
    }
}