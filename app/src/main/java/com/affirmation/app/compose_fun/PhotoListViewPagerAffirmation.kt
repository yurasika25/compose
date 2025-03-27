package com.affirmation.app.compose_fun


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.affirmation.app.data.Datasource
import com.affirmation.app.model.Affirmation
import com.affirmation.app.navigation.NavRouts
import java.nio.file.WatchEvent


@Composable
fun AffirmationHomeList(
    affirmationList: List<Affirmation>,
    modifier: Modifier = Modifier,
    navController: NavController?
) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationHomeCard(
                affirmation = affirmation,
                modifier = Modifier
                    .clickable {
                        navController?.navigate(
                            NavRouts.DetailsScreen(
                                navController.context.getString(
                                    affirmation.title, affirmation.imageResourceId
                                ), affirmation.imageResourceId
                            )
                        )
                    }
            )
        }
    }
}

@Composable
fun AffirmationHomeCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.padding(vertical = 6.dp),
        shape = RoundedCornerShape(34F, 34F, 34F, 34F)
    ) {
        Box(modifier = Modifier
            .height(120.dp)
            .fillMaxSize()) {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = affirmation.title),
                color = Color.White,
                fontSize = 48.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun AffirmationHomeListPreview() {
    AffirmationHomeList(
        Datasource().loadAffirmationsList(),
        Modifier.padding(0.dp),
        null
    )
}