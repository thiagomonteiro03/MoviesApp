package com.montway.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
)

//fake objects
val movie1 = Movie(
    id = 1,
    title = "Minecraft",
    overview = "Movie overview",
    posterUrl = "https://example.com/poster1.jpg"
)
