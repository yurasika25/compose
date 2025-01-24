package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.repository.repositoryModule
import com.example.jetpackcompose.di.viewModelModules
import com.example.jetpackcompose.navigation.MainNavHost
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinApplication(application = {
                modules(viewModelModules)
                modules(repositoryModule)
            }) {
                MainNavHost()
            }
        }
    }
}


