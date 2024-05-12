package com.example.movieappmad24.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Dao
interface MovieDao {

    @Insert
    suspend fun add(movie: Movie)
    @Update
    suspend fun update(movie: Movie)
    @Delete
    suspend fun delete(movie: Movie)
    @Insert
    suspend fun addImage(movieImage: MovieImage)

    @Transaction
    @Query("SELECT * FROM movie WHERE movie.movieId = :movieId")
    fun getMovieByID(movieId: String?): Flow<MovieWithImages>?

    @Transaction
    @Query("SELECT * FROM movie")
    fun readAll(): Flow<List<MovieWithImages>>

    @Transaction
    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun readAllFavorites(): Flow<List<MovieWithImages>>

}