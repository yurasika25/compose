package com.affirmation.app.compose_fun

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.affirmation.app.R
import com.affirmation.app.navigation.MainNavHost
import com.affirmation.app.navigation.NavRouts
import com.affirmation.app.navigation.navigationItem
import com.affirmation.app.extension.checkRout


@Composable
fun MainHome() {
    val navController = rememberNavController()
    var selectedItem by remember { mutableStateOf(0) }

    val stackEntry by navController.currentBackStackEntryFlow.collectAsStateWithLifecycle(
        initialValue = null
    )

    val shouldHideBottomNav by remember(stackEntry?.destination) {
        derivedStateOf {
            stackEntry?.destination?.checkRout(NavRouts.DetailsScreen(), NavRouts.Game()) ?: false
        }
    }

    Scaffold(
        bottomBar = {
            AnimatedContent(
                targetState = !shouldHideBottomNav,
                transitionSpec = {
                    (fadeIn(animationSpec = tween(300)) + slideInVertically(initialOffsetY = { it })).togetherWith(
                        fadeOut(animationSpec = tween(300)) + slideOutVertically(targetOffsetY = { it })
                    )
                }, label = "bottomBar"
            )
            { visible ->
                if (visible) {
                    Surface(
                        color = colorResource(id = R.color.teal_700),
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                        elevation = 8.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                    ) {
                        BottomNavigation(
                            modifier = Modifier.navigationBarsPadding(),
                            backgroundColor = colorResource(id = R.color.teal_700),
                            elevation = 8.dp
                        ) {
                            navigationItem(
                                navController,
                                R.drawable.ic_home,
                                0,
                                "Home",
                                NavRouts.HomeScreen,
                                selectedItem
                            ) {
                                selectedItem = it
                            }
                            navigationItem(
                                navController,
                                R.drawable.ic_favorite,
                                1,
                                "Favourite",
                                NavRouts.AffirmationScreen,
                                selectedItem
                            ) {
                                selectedItem = it
                            }
                            navigationItem(
                                navController,
                                R.drawable.ic_notifications,
                                2,
                                "Notifications",
                                NavRouts.Notifications,
                                selectedItem
                            ) {
                                selectedItem = it
                            }
                            navigationItem(
                                navController,
                                R.drawable.ic_profile,
                                3,
                                "Profile",
                                NavRouts.MyProfile,
                                selectedItem
                            ) {
                                selectedItem = it
                            }
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            MainNavHost(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationBar() {
    MainHome()
}