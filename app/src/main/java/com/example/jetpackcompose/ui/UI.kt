package com.example.jetpackcompose.ui


sealed class NavRouts(val route: String) {
    data object HomeScreen: NavRouts("home")
    data object SecondScreen: NavRouts("secondFragment")
    data object ThirdScreen: NavRouts("thirdFragment")
}