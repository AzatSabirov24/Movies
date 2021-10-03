package com.azat_sabirov.movies.viewModel

import com.azat_sabirov.movies.model.Movie

sealed class AppState {
    data class Success(val movieDataReleased: List<Movie>, val movieDataExpected: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}