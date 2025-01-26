package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.compose_fun.AffirmationsApp
import com.example.jetpackcompose.compose_fun.HomeFragmentScreen
import com.example.jetpackcompose.compose_fun.MyProfile
import com.example.jetpackcompose.compose_fun.ThirdFragmentScreen
import com.example.jetpackcompose.ui.NavRouts

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRouts.HomeScreen
    ) {
        composable<NavRouts.HomeScreen> {
            HomeFragmentScreen(navController)
        }
        composable<NavRouts.SecondScreen> {
            AffirmationsApp(navController)
        }
        composable<NavRouts.ThirdScreen> {
            ThirdFragmentScreen(
                navController = navController
            )
        }
        composable<NavRouts.MyProfile> {
            MyProfile(navController)
        }
    }
}