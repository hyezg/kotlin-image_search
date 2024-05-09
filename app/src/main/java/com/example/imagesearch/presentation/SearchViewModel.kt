package com.example.imagesearch.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.imagesearch.data.ImageResponse
import com.example.imagesearch.data.SearchRepositoryImpl
import com.example.imagesearch.retrofit.NetWorkClient
import com.example.imagesearch.retrofit.NetWorkInterface
import kotlinx.coroutines.launch
import com.example.imagesearch.repository.SearchRepository

class SearchViewModel(
    private val kakaoSearch: NetWorkInterface, private val searchRepository: SearchRepository
) : ViewModel() {

    //viewModel에서 liveData에 값 세팅
    private val _kakaoList: MutableLiveData<List<ImageResponse.Document>?> = MutableLiveData()

    //view에서 livedata값 observing할 것
    val kakaoList: MutableLiveData<List<ImageResponse.Document>?> get() = _kakaoList

    fun getKakaoList() {
        viewModelScope.launch {
            _kakaoList.value =
                kakaoSearch.getImage("사과").documents

        }
    }


    //수업에서 가져온 것
    //좋아요 누른 아이템
    /*fun setFavoriteItem(item: ImageSearchEntity) {
        //toMutableList 수정가능 한 List로 변경
        val kakaoList = _kakaoList.value!!.toMutableList()

        //매칭된 아이템의 index를 반환
        val position = kakaoList.indexOfFirst {
            it.thumbnailUrl == item.thumbnailUrl
        }
        /
        _kakaoList.value =
                //livedata에서 받아온 list를 index으로 sorting해서 data class copy함 (data class의 객체를 복사)
            kakaoList.also {
                it[position] = item.copy(
                    //bool 값을 반대값 세팅
                    isFavorite = !item.isFavorite
                )
            }   // response list -> isLike

        //true인 값만 넣음
        _kakaoList.value = kakaoList.filter {
            it.isFavorite
        }
    }*/
}

/*
class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return SearchViewModel(NetWorkClient.kakaoSearch) as T
    }

}*/

class GitHubUserViewModelFactory : ViewModelProvider.Factory {
    private val repository = SearchRepositoryImpl(NetWorkClient.kakaoSearch)
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return SearchViewModel(
            repository
        ) as T
    }
}