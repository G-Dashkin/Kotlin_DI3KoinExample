package com.example.kotlin_di3koinexample.Koin5Retrofit.api

import com.example.kotlin_di3koinexample.BuildConfig
import com.example.kotlin_di3koinexample.Koin5Retrofit.models.Photo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("api/")
    suspend fun getPhoto(
        @Query("q") searchQuery: String,
        @Query("image_type") imageType: String = "photo",
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): Response<Photo>
}