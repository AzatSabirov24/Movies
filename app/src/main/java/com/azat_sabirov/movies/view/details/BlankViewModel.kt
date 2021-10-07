package com.azat_sabirov.movies.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azat_sabirov.movies.MainRepository
import com.azat_sabirov.movies.model.MovieDetailDTO
import kotlinx.coroutines.launch

class BlankViewModel(private val mainRepository: MainRepository) : ViewModel(){
    var movieDetailLiveData = MutableLiveData<MovieDetailDTO>()
/*
    init{
        getMovieDetail(1143242)
    }*/

    fun getMovieDetail(movieId: Int){
        viewModelScope.launch {
            val token = "bf91fd8982ead6ab61aa0504004602e7"
            val data = mainRepository.getMovieDetail(token, movieId)
            movieDetailLiveData.value = data
        }
    }
}