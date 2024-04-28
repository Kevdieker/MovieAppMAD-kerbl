package com.example.movieappmad24.widget

import android.util.Log
import androidx.compose.foundation.clickable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun FavoriteIcon(
    modifier: Modifier,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit = {}
) {
    Icon(
        modifier = modifier,
        tint = if (!isFavorite) Color.White else Color.Red,
        imageVector = Icons.Filled.Favorite,
        contentDescription = "heart"
    )
}