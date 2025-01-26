package com.example.jetpackcompose.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.jetpackcompose.R

@Composable
fun <T : Any> RowScope.nav(
    navController: NavHostController,
    iconRes: Int,
    itemSelected: Int = 0,
    label: String,
    routs: T,
    selectedItem: Int,
    updateSelectedItem: (Int) -> Unit
) {
    BottomNavigationItem(
        icon = {
            Image(
                painter = painterResource(iconRes),
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    if (selectedItem == itemSelected) colorResource(id = R.color.white) else colorResource(
                        id = R.color.grey
                    )
                )
            )
        },
        label = {
            Text(
                text = label,
                color = if (selectedItem == itemSelected) colorResource(id = R.color.white) else colorResource(
                    id = R.color.grey
                )
            )
        },
        selected = selectedItem == itemSelected,
        onClick = {
            navController.navigate(routs)
            updateSelectedItem(itemSelected)
        }
    )
}