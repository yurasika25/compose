package com.affirmation.app.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.affirmation.app.data.Datasource
import com.affirmation.app.model.Affirmation
import com.affirmation.app.navigation.NavRouts

@Composable
fun AffirmationsApp(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(title = "Affirmations", navController = navController)
        },
    ) {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(), Modifier.padding(it), navController
        )
    }
}

@Composable
fun AffirmationList(
    affirmationList: List<Affirmation>,
    modifier: Modifier = Modifier,
    navController: NavController?
) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier
                    .padding(8.dp)
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
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.title),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun AffirmationsAppPreview() {
    AffirmationsApp()
}