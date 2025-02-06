package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.compose_fun.AffirmationDetailsScreen
import com.example.jetpackcompose.compose_fun.AffirmationsApp
import com.example.jetpackcompose.compose_fun.HomeScreen
import com.example.jetpackcompose.compose_fun.MainGameScreen
import com.example.jetpackcompose.compose_fun.MyProfileScreen
import com.example.jetpackcompose.compose_fun.Notifications

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRouts.HomeScreen
    ) {
        composable<NavRouts.HomeScreen> {
            HomeScreen(navController)
        }
        composable<NavRouts.AffirmationScreen> {
            AffirmationsApp(navController)
        }
        composable<NavRouts.MyProfile> {
            MyProfileScreen(navController)
        }
        composable<NavRouts.Notifications> {
            Notifications(navController)
        }
        composable<NavRouts.DetailsScreen> {
            AffirmationDetailsScreen(navController)
        }
        composable<NavRouts.Game>() {
            MainGameScreen(navController)
        }
    }
}