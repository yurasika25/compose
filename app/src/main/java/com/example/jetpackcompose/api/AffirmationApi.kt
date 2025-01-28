package com.example.jetpackcompose.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AffirmationApi {
    @POST("affirmation/data")
    suspend fun getData(@Body args: String): Response<String>
}