package com.example.imagesearch.repository

import com.example.imagesearch.data.ImageSearchListEntity

interface SearchRepository {
    suspend fun getImageSearchList(thumbnailUrl: String): ImageSearchListEntity
}