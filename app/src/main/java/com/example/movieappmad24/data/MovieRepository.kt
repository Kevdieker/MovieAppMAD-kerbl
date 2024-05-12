package com.example.movieappmad24.data

import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage

class MovieRepository(private val movieDao: MovieDao) {
    suspend fun add(movie: Movie) = movieDao.add(movie)
    suspend fun delete(movie: Movie) = movieDao.delete(movie)
    suspend fun addImage(movieImage: MovieImage) = movieDao.addImage(movieImage)
    suspend fun update(movie: Movie) = movieDao.update(movie)
    fun getMovieById(movieId: String?) = movieDao.getMovieByID(movieId)
    fun getFavoriteMovies() = movieDao.readAllFavorites()
    fun getAllMovies() = movieDao.readAll()

    companion object {

        @Volatile private var instance: MovieRepository? = null

        fun getInstance(dao: MovieDao) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(dao).also { instance = it }
            }
    }
}