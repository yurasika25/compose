package com.example.jetpackcompose.compose_fun

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun Notifications(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(title = "Notifications", navController = navController)
        },
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Notifications")
        }
    }
}

@Composable
@Preview
fun NotificationsPreview() {
    Notifications()
}