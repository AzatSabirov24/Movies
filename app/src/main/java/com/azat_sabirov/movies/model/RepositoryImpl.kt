package com.azat_sabirov.movies.model

class RepositoryImpl : Repository {
    override fun getMovieFromLocalStorageReleased(): List<Movie> {
        return getReleasedMovie()
    }

    override fun getMovieFromLocalStorageExpected(): List<Movie> {
        return getExpectedMovie()
    }

    override fun getMovieFromServer(): Movie {
        return Movie()
    }
}