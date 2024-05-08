package com.example.imagesearch.data

import com.google.gson.annotations.SerializedName

data class Image(val response: ImageResponse)

data class ImageListResponse(
    @SerializedName("documents") val documents: List<ImageResponse>

)

data class ImageResponse(
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("display_sitename") val sitename: String,
    @SerializedName("datetime") val date: String

)

data class ImageItem (
    val collection: String,
    val width: Integer,
    val height: Integer,
    val thumbnailUrl: String,
    val date: String,
    val sitename: String
)

data class SaveData (
    val collection: String,
    val width: Integer,
    val height: Integer,
    val thumbnailUrl: String,
    val date: String,
    val sitename: String
)