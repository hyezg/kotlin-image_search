package com.example.imagesearch.data

import com.example.imagesearch.mapper.toEntity
import com.example.imagesearch.repository.SearchRepository
import com.example.imagesearch.retrofit.NetWorkInterface

class SearchRepositoryImpl(
    private val remoteDataSource: NetWorkInterface
) : SearchRepository {

    override suspend fun getImageSearchList(thumbnailUrl: String): ImageSearchListEntity {
        remoteDataSource.getImage(thumbnailUrl).toEntity()
        return TODO("Provide the return value")
    }
}