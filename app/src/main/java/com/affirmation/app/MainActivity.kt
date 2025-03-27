package com.affirmation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.affirmation.app.compose_fun.MainHome
import com.affirmation.app.di.resModule
import com.affirmation.app.di.viewModelModules
import com.affirmation.app.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
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


