package com.montway.movies.data.mapper

import com.montway.movies.data.network.IMAGE_SMALL_BASE_URL
import com.montway.movies.data.network.model.CastMemberResponse
import com.montway.movies.domain.model.CastMember
import com.montway.movies.domain.model.ImageSize

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    mainRole = this.department,
    name = this.name,
    character = this.character,
    profilePath = "$IMAGE_SMALL_BASE_URL/${ImageSize.XSMALL.size}/${this.profilePath}",
)