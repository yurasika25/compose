package com.example.jetpackcompose.navigation

import kotlinx.serialization.Serializable


sealed class NavRouts {

    @Serializable
    data object HomeScreen

    @Serializable
    data object AffirmationScreen

    @Serializable
    data class DetailsScreen(val title: String, val imageResId: Int)

    @Serializable
    data object MyProfile

    @Serializable
    data object Notifications

    @Serializable
    data class Game(val name: String? = null)
}