package com.example.jetpackcompose.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.ProfileDatasource
import com.example.jetpackcompose.model.ProfileAffirmation
import com.example.jetpackcompose.navigation.NavRouts

@Composable
fun MyProfile(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(title = "My Profile", navController = navController)
        },
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
            ProfileStats()
            Spacer(modifier = Modifier.height(16.dp))
            FollowButton()
            ProfileAffirmationList(
                affirmationList = ProfileDatasource().loadProfileAffirmations(), Modifier.padding(top = 16.dp), navController
            )
        }
    }
}

@Composable
fun ProfileAffirmationList(
    affirmationList: List<ProfileAffirmation>,
    modifier: Modifier = Modifier,
    navController: NavController?
) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            MyProfileCard(
                affirmation = affirmation,
                modifier = Modifier
                    .padding(vertical = 8.dp)
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
fun MyProfileCard(affirmation: ProfileAffirmation, modifier: Modifier = Modifier) {
    Row(modifier.padding(0.dp)) {
        Image(
            painter = painterResource(affirmation.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(Modifier.fillMaxWidth()) {
            Text(
                text = LocalContext.current.getString(affirmation.title),
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 18.sp
            )

            Text(
                text = LocalContext.current.getString(affirmation.subTitle),
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun FollowButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(48.dp)
    ) {
        Text(
            text = "Follow",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_letter),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(1.5.dp, colorResource(id = R.color.green), CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Yurii Sika",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Android Developer | Jetpack Compose Enthusiast",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ProfileStats() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        StatItem("Posts", "150")
        StatItem("Followers", "2.5K")
        StatItem("Following", "300")
        StatItem("Likes", "4k")
    }
}

@Composable
fun StatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
@Preview
fun MyProfilePreview() {
    MyProfile()
}