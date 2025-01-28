package com.example.jetpackcompose.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.navigation.NavRouts
import com.example.jetpackcompose.viewModel.AffirmationData
import com.example.jetpackcompose.viewModel.AffirmationDetailsViewModel
import com.example.jetpackcompose.viewModel.Game
import org.koin.androidx.compose.koinViewModel

@Composable
fun AffirmationDetailsScreen(navController: NavController? = null) {
    val viewModel = koinViewModel<AffirmationDetailsViewModel>()
    val gameList by viewModel.gamesList.collectAsState()
    AffirmationDetails(
        navController = navController,
        data = viewModel.affirmationData.value,
        gameList
    )
}

@Composable
fun AffirmationDetails(
    navController: NavController?,
    data: AffirmationData?,
    gameList: List<Game>
) {
    val context = LocalContext.current

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
    ) {
        Modifier.padding(it)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 46.dp)) {
                items(gameList) { game ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(40.dp)
                            .clickable {
                                navController?.navigate(NavRouts.Game(game.name))
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(80.dp)
                                    .height(40.dp)
                                    .padding(8.dp)
                            ) {
                                Image(
                                    painter = painterResource(game.imageResId ?: R.drawable.image1),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            game.name?.let { it1 ->
                                Text(
                                    text = it1,
                                    fontSize = 18.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
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
        BottomSheetContent(context = context, isSheetOpen = isSheetOpen, sharedTextState)
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