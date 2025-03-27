package com.affirmation.app.compose_fun

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.affirmation.app.viewModel.GameViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainGameScreen(navController: NavController? = null) {
    val viewModel = koinViewModel<GameViewModel>()
    GameScreen(
        navController = navController,
        viewModel.gameData.value
    )
}

@Composable
fun GameScreen(navController: NavController? = null, data: String?) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(
                title = "Game",
                navController = navController,
                showIcon = true
            )
        },
    ) { paddingValues ->

        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .wrapContentSize(Alignment.Center),
            text = data ?: "Empty",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun GamePreview() {
    MainGameScreen(null)
}