package com.affirmation.app.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.affirmation.app.R
import com.affirmation.app.navigation.NavRouts
import com.affirmation.app.viewModel.Game


@Composable
fun GamesList(
    gameList: List<Game>,
    navController: NavController?
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 46.dp)
    ) {
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
}

@Composable
@Preview
fun gavePreview() {
    val sampleGamesList = listOf(
        Game(name = "Chess", imageResId = R.drawable.image5),
        Game(name = "Sudoku", imageResId = R.drawable.image5),
        Game(name = "Crossword", imageResId = R.drawable.image5),
    )
    GamesList(sampleGamesList, null)
}