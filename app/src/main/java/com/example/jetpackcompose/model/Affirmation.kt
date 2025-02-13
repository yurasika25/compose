package com.example.jetpackcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val title: Int,
    @DrawableRes val imageResourceId: Int
)
