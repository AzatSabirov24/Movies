package com.azat_sabirov.movies.model

class RepositoryImpl : Repository {
    override fun getMovieFromLocalStorageReleased() = getReleasedMovie()

    override fun getMovieFromLocalStorageExpected() = getExpectedMovie()

    override fun getMovieFromServer() = Movie()
}