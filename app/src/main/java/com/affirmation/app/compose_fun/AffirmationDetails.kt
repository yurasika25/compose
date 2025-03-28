package com.affirmation.app.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.affirmation.app.R
import com.affirmation.app.viewModel.AffirmationData
import com.affirmation.app.viewModel.AffirmationDetailsViewModel
import com.affirmation.app.viewModel.Game
import org.koin.androidx.compose.koinViewModel

@Composable
fun AffirmationDetailsScreen(navController: NavController) {
    val viewModel = koinViewModel<AffirmationDetailsViewModel>()
    val gameList by viewModel.gamesList.collectAsStateWithLifecycle()
    val affirmation by viewModel.affirmationData.collectAsStateWithLifecycle()

    AffirmationDetails(
        navController = navController,
        data = affirmation,
        gameList = gameList,
    )
}

@Composable
private fun AffirmationDetails(
    navController: NavController?,
    data: AffirmationData?,
    gameList: List<Game>
) {
    var text by remember { mutableStateOf("") }
    val sharedTextState = remember { mutableStateOf("Your Text") }

    val isSheetOpen = remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(
                title = "Affirmation Details",
                navController = navController,
                showIcon = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    sharedTextState.value = text
                    isSheetOpen.value = true
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "FAB Icon")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { it ->
        Modifier.padding(it)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            GamesList(gameList, navController)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            ) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(data?.imageResId ?: R.drawable.image1),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter your text") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = data?.title ?: "",
                        fontSize = 24.sp,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Open the next screen or close the app",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        BottomSheetContent(isSheetOpen = isSheetOpen, sharedTextState)
    }
}

@Preview
@Composable
fun AffirmationDetailsPreview() {

    val sampleGamesList = listOf(
        Game(name = "Chess", imageResId = R.drawable.image5),
        Game(name = "Sudoku", imageResId = R.drawable.image5),
        Game(name = "Crossword", imageResId = R.drawable.image5)
    )
    AffirmationDetails(
        navController = null,
        data = AffirmationData(
            title = "Affirmation",
            imageResId = R.drawable.image1
        ),
        sampleGamesList
    )
}