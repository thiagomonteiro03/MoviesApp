package com.montway.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform