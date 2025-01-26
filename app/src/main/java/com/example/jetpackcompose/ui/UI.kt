package com.example.jetpackcompose.ui

import kotlinx.serialization.Serializable


sealed class NavRouts {

    @Serializable
    data object HomeScreen

    @Serializable
    data object SecondScreen

    @Serializable
    data class ThirdScreen(val title: String, val imageResId: Int)

    @Serializable
    data object MyProfile
}