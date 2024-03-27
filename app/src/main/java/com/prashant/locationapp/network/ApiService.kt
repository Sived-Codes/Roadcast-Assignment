package com.prashant.locationapp.network

import com.prashant.locationapp.model.MovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movies")
    suspend fun getMovie(): List<MovieResponse>
}