package com.affirmation.app.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.affirmation.app.R
import com.affirmation.app.data.Datasource

@Composable
fun Home(navController: NavController? = null) {
    HomeScreen(navController)
}

@Composable
fun HomeScreen(
    navController: NavController? = null
) {
    val affirmations = Datasource().loadAffirmationsPagerList()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Column {
                Text(
                    text = "Good Morning, Yurii!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.dark_grey)
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = "Today is February 6, 2025",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Card(
                elevation = CardDefaults.cardElevation(0.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.grey)),
                shape = CircleShape,
                modifier = Modifier
                    .width(63.dp)
                    .height(63.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.im_me),
                    contentDescription = "Avatar",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Text(
            color = colorResource(id = R.color.dark_grey),
            text = "Today’s Exercise",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
        PhotoListViewPagerAffirmation(affirmations)

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                color = colorResource(id = R.color.dark_grey),
                text = "Today’s Exercise",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.weight(1f))

            Text(
                color = Color.Gray,
                text = "View All",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AffirmationHomeList(
            affirmationList = Datasource().loadAffirmationsList(),
            Modifier.padding(horizontal = 16.dp),
            navController
        )
    }
}


@Preview
@Composable
fun HomePreview() {
    Home(null)
}