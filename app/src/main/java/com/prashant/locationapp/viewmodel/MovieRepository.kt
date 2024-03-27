package com.prashant.locationapp.viewmodel

import com.prashant.locationapp.model.MovieResponse
import com.prashant.locationapp.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MovieRepository @Inject constructor(private val apiService: ApiService) {

    fun getMovie(): Flow<List<MovieResponse>> = flow {
        val response = apiService.getMovie()
        emit(response)
    }.flowOn(Dispatchers.IO)
}
