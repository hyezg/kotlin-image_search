package com.example.imagesearch.retrofit

import com.example.imagesearch.data.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

//data source?
interface NetWorkInterface {
    @GET("v2/search/image")
    suspend fun getImage(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
        @Header("Authorization") authorization: String = "KakaoAK 49f21a3e387c2a825f6c3393d00b94cc"
    ): ImageResponse
}