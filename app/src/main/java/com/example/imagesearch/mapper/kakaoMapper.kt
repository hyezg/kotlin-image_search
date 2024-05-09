package com.example.imagesearch.mapper

import com.example.imagesearch.data.ImageResponse
import com.example.imagesearch.data.ImageSearchEntity
import com.example.imagesearch.data.ImageSearchListEntity


fun ImageResponse.toEntity() = ImageSearchListEntity(
    documents = documents.asImageSearchEntity()
)

fun List<ImageResponse>.asImageSearchEntity(): List<ImageSearchEntity> {
    return map {
        ImageSearchEntity(
            it.datetime

        )
    }
}
