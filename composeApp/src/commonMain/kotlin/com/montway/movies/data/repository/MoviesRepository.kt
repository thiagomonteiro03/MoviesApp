package com.montway.movies.data.repository

import com.montway.movies.data.mapper.toModel
import com.montway.movies.domain.model.MovieSection
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import com.montway.movies.data.network.KtorClient
import com.montway.movies.domain.model.ImageSize
import com.montway.movies.domain.model.Movie

class MoviesRepository(
    private val ktorClient: KtorClient,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val popularMoviesDeferred = async { ktorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { ktorClient.getMovies("top_rated") }
            val upcomingMoviesDeferred = async { ktorClient.getMovies("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = popularMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = topRatedMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = upcomingMovies.results.map { it.toModel() }
                )
            )
        }
    }

    suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return withContext(ioDispatcher) {
            runCatching {
                val movieDetailDeferred = async { ktorClient.getMovieDetail(movieId) }
                val creditsDeferred = async { ktorClient.getCredits(movieId) }
                val videosDeferred = async { ktorClient.getVideos(movieId) }

                val movieDetailResponse = movieDetailDeferred.await()
                val creditsListResponse = creditsDeferred.await()
                val videosListResponse = videosDeferred.await()

                val movieTrailerYoutubeKey = videosListResponse.results.firstOrNull { videoResponse ->
                    videoResponse.site == "YouTube"
                }?.key

                movieDetailResponse.toModel(
                    imageSize = ImageSize.XLARGE,
                    castMembersResponse = creditsListResponse.cast,
                    movieTrailerYoutubeKey = movieTrailerYoutubeKey
                )
            }
        }
    }
}