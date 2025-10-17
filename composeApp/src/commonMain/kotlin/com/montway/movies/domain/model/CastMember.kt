package com.montway.movies.domain.model

data class CastMember(
    val id: Int,
    val mainRole: String,
    val name: String,
    val character: String,
    val profilePath: String,
)

val castMember1 = CastMember(
    id = 1,
    mainRole = "Acting",
    name = "John Doe",
    character = "John Name",
    profilePath = "url"
)

val castMember2 = CastMember(
    id = 2,
    mainRole = "Acting",
    name = "Jane Doe",
    character = "Jane Name",
    profilePath = "url"
)
