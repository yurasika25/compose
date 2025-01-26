package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.compose_fun.AffirmationsApp
import com.example.jetpackcompose.compose_fun.HomeFragmentScreen
import com.example.jetpackcompose.compose_fun.MyProfile
import com.example.jetpackcompose.compose_fun.Details
import com.example.jetpackcompose.compose_fun.Notifications


@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRouts.HomeScreen
    ) {
        composable<NavRouts.HomeScreen> {
            HomeFragmentScreen(navController)
        }
        composable<NavRouts.AffirmationScreen> {
            AffirmationsApp(navController)
        }
        composable<NavRouts.MyProfile> {
            MyProfile(navController)
        }
        composable<NavRouts.Notifications> {
            Notifications(navController)
        }
        composable<NavRouts.DetailsScreen> {
            Details(navController)
        }
    }
}