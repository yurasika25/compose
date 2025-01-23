package com.example.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.compose_fun.AffirmationsApp
import com.example.jetpackcompose.compose_fun.HomeFragmentScreen
import com.example.jetpackcompose.compose_fun.ThirdFragmentScreen
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
        composable(
            NavRouts.ThirdScreen.route,
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("imageResId") { type  = NavType.IntType}
                )
        ) { backStackEntry ->
            ThirdFragmentScreen(
                navController = navController,
                title = backStackEntry.arguments?.getString("title"),
                imageResId = backStackEntry.arguments?.getInt("imageResId")
            )
        }
    }
}