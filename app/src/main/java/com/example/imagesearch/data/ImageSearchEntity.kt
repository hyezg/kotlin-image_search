package com.example.imagesearch.data

data class ImageSearchListEntity(val documents: List<ImageSearchEntity>)
data class ImageSearchEntity(
    val thumbnailUrl: String,
    val datetime: String,
    val displaySitename: Int,
    val isFavorite: Boolean = false
)
//isFavorite를 사용하기 위해 만듦