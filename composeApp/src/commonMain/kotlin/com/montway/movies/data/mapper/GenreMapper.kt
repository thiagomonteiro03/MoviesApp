package com.montway.movies.data.mapper

import com.montway.movies.data.network.model.GenreResponse
import com.montway.movies.domain.model.Genre

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name,
)