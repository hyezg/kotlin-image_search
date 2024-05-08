package com.example.imagesearch.retrofit

import com.example.imagesearch.data.Image
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NetWorkInterface {
    @GET("v2/search/image")
    suspend fun getImage(@QueryMap param: HashMap<String, String>): Image

}