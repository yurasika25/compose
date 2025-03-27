package com.affirmation.app.data

data class DataState<T>(
    var state: String,
    val data: T?
)