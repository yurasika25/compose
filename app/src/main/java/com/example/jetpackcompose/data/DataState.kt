package com.example.jetpackcompose.data

data class DataState<T>(
    var state: String,
    val data: T?
)