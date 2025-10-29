package com.montway.movies.data.mapper

import com.montway.movies.data.network.IMAGE_SMALL_BASE_URL
import com.montway.movies.data.network.model.CastMemberResponse
import com.montway.movies.data.network.model.MovieResponse
import com.montway.movies.domain.model.ImageSize
import com.montway.movies.domain.model.Movie
import com.montway.movies.utils.formatRating

fun MovieResponse.toModel(
    imageSize: ImageSize = ImageSize.SMALL,
    castMembersResponse: List<CastMemberResponse>? = null,
    movieTrailerYoutubeKey: String? = null,
) = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL/${imageSize.size}/${this.posterPath}",
    genres = this.genres?.map { it.toModel() },
    year = this.getYearFromReleaseDate(),
    duration = this.getDurationInHoursAndMinutes(),
    rating = this.voteAverage.formatRating(),
    castMembers = castMembersResponse
        ?.filter { it.department == "Acting" }
        ?.take(20)
        ?.map { it.toModel() },
    movieTrailerYoutubeKey = movieTrailerYoutubeKey
)

private fun MovieResponse.getYearFromReleaseDate(): Int {
    return this.releaseDate.year
}

private fun MovieResponse.getDurationInHoursAndMinutes(): String? {
    return this.runtime?.let { runtimeMinutes ->
        val hours = runtimeMinutes / 60
        val minutes = runtimeMinutes % 60

        buildString {
            if (hours > 0) {
                append("${hours}h ")
            }

            append("${minutes}min")
        }
    }
}