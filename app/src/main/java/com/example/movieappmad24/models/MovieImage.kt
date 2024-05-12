package com.example.movieappmad24.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieImage(
    @PrimaryKey(autoGenerate = true)
    val imageId: Long = 0,
    val movie2Id: Long,
    val url: String
)