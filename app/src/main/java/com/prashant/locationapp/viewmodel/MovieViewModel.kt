package com.prashant.locationapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prashant.locationapp.model.MovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val postRepository: MovieRepository)  : ViewModel(){

    private val _response: MutableLiveData<List<MovieResponse>> = MutableLiveData()
    val response: LiveData<List<MovieResponse>> = _response
    // val postLiveData : MutableLiveData<List<MovieResponse>> = MutableLiveData()

    fun getMovie(){
        viewModelScope.launch {
            postRepository.getMovie()
                .catch {e->
                    Log.e("MainViewModel_ERROR", "getPost: ${e.message}")
                }.collect {response->
                    _response.value = response
                    // postLiveData.value=response
                }

        }
    }
}