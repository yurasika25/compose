package com.example.jetpackcompose.compose_fun

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopAppBar(
    title: String,
    navController: NavController? = null,
    showIcon: Boolean = false
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (showIcon) {
                IconButton(onClick = {
                    navController?.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewTopAppBar() {
    DynamicTopAppBar("Home", null, true)
}
