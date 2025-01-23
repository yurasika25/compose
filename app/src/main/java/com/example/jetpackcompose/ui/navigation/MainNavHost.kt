package com.example.jetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.compose_fun.AffirmationsApp
import com.example.jetpackcompose.compose_fun.HomeFragmentScreen
import com.example.jetpackcompose.ui.NavRouts

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRouts.HomeScreen.route
    ) {
        composable(NavRouts.HomeScreen.route) {
            HomeFragmentScreen(navController)
        }
        composable(NavRouts.SecondScreen.route) {
            AffirmationsApp(navController)
        }
        composable(NavRouts.SecondScreen.route) {
            AffirmationsApp(navController)
        }
    }
}