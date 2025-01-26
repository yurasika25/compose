package com.example.jetpackcompose.compose_fun

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.navigation.MainNavHost
import com.example.jetpackcompose.navigation.NavRouts
import com.example.jetpackcompose.navigation.nav

@Composable
fun MainHome() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.teal_700),
                elevation = 8.dp
            ) {
                nav(navController, R.drawable.ic_home, 0, "Home", NavRouts.HomeScreen, selectedItem) {
                    selectedItem = it
                }
                nav(navController, R.drawable.ic_favorite, 1, "Favourite", NavRouts.AffirmationScreen, selectedItem) {
                    selectedItem = it
                }
                nav(navController, R.drawable.ic_notifications, 2, "Notifications", NavRouts.Notifications, selectedItem) {
                    selectedItem = it
                }
                nav(navController, R.drawable.ic_profile, 3, "Profile", NavRouts.MyProfile, selectedItem) {
                    selectedItem = it
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            MainNavHost(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationBar() {
    MainHome()
}