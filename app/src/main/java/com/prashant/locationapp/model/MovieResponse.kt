package com.prashant.locationapp.model

data class MovieResponse(
    val id: Int,
    val movie: String,
    val rating: Double,
    val image: String,
    val imdb_url: String
)