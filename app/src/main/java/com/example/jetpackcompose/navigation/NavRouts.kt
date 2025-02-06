package com.example.jetpackcompose.navigation

import com.example.jetpackcompose.R
import kotlinx.serialization.Serializable

@Serializable
sealed class NavRouts {

    @Serializable
    data object HomeScreen: NavRouts()

    @Serializable
    data object AffirmationScreen: NavRouts()

    @Serializable
    data class DetailsScreen(val title: String = "", val imageResId: Int = R.drawable.image5): NavRouts()

    @Serializable
    data object MyProfile: NavRouts()

    @Serializable
    data object Notifications: NavRouts()

    @Serializable
    data class Game(val name: String? = null): NavRouts()
}