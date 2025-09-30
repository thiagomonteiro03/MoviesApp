package com.montway.movies.domain.model

import com.montway.movies.data.network.IMAGE_SMALL_BASE_URL
import com.montway.movies.data.network.model.MoviesResponse

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
)

fun MoviesResponse.toModel() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}"
)

//fake objects
val movie1 = Movie(
    id = 1,
    title = "Minecraft",
    overview = "Movie overview",
    posterUrl = "$IMAGE_SMALL_BASE_URL/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg"
)
