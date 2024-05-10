package com.example.imagesearch

/**
 * Entity 랑 비슷함
 * 좋아요 누른 아이템때문에 기본 데이터에 없는 isLike 추가해 준것
*/
data class SearchItemModel(
    var title: String,
    var dateTime: String,
    var url: String,
    var isLike: Boolean = true
)