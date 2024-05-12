package com.example.movieappmad24.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieImage

@Database(
    entities = [Movie::class,MovieImage::class],
    version = 1                                                                                                                                                                   ,
    exportSchema = false,
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile //preventCaching
        private var Instance: MovieDatabase? = null
        fun getDatabase(context: Context): MovieDatabase {
            return Instance ?: synchronized(this) { //prevent multithreading code-block
                Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}