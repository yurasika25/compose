package com.affirmation.app.compose_fun

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.affirmation.app.data.Datasource
import com.affirmation.app.model.Affirmation

@Composable
fun PhotoListViewPagerAffirmation(affirmations: List<Affirmation>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { affirmations.size })

    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        ) { page ->
            val affirmation = affirmations[page]
            Card(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(34F, 34F, 34F, 34F)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
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
    }
}

@Composable
@Preview
fun PhotoListAffirmationPreview() {
    val affirmations = Datasource().loadAffirmations()
    PhotoListViewPagerAffirmation(affirmations = affirmations)
}
