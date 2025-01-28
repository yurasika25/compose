package com.example.jetpackcompose.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcompose.R

@Composable
fun HomeScreen(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(
                title = "Home",
                navController = navController,
                showIcon = false
            )
        },
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxHeight()
                .fillMaxWidth()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "This is the home screen",
                fontSize = 24.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Open the next screen or close the app",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_letter),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 20.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}