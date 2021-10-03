package com.azat_sabirov.movies.model

interface Repository {
    fun getMovieFromLocalStorageReleased() : List<Movie>
    fun getMovieFromLocalStorageExpected() : List<Movie>
    fun getMovieFromServer() : Movie
}