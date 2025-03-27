package com.affirmation.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.affirmation.app.compose_fun.AffirmationDetailsScreen
import com.affirmation.app.compose_fun.AffirmationsApp
import com.affirmation.app.compose_fun.HomeScreen
import com.affirmation.app.compose_fun.MainGameScreen
import com.affirmation.app.compose_fun.MyProfileScreen
import com.affirmation.app.compose_fun.Notifications

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