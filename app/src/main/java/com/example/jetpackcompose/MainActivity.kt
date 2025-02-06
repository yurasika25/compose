package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcompose.compose_fun.MainHome
import com.example.jetpackcompose.di.resModule
import com.example.jetpackcompose.di.viewModelModules
import com.example.jetpackcompose.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinApplication(application = {
                androidContext(this@MainActivity)
                modules(viewModelModules)
                modules(repositoryModule)
                modules(resModule)
            }) {
                MainHome()
            }
        }
    }
}


