package com.azat_sabirov.movies.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azat_sabirov.movies.model.Movie
import com.azat_sabirov.movies.model.Repository
import com.azat_sabirov.movies.model.RepositoryImpl

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataToObserve

    fun getMovieFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        Thread {
            liveDataToObserve.postValue(
                AppState.Success(
                    repository.getMovieFromLocalStorageReleased(),
                    repository.getMovieFromLocalStorageExpected()
                )
            )
        }.start()
    }
}