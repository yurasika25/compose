package com.example.jetpackcompose.compose_fun

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopAppBar(
    title: String,
    navController: NavController? = null
) {
    TopAppBar(title = {
        Text(text = title)
    }, navigationIcon = {
        IconButton(onClick = {
            navController?.popBackStack()
        }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = null)
        }
    })
}