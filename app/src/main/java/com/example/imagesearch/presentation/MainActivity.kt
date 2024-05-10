package com.example.imagesearch.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imagesearch.R
import com.example.imagesearch.SearchItemModel
import com.example.imagesearch.databinding.ActivityMainBinding
import com.example.imagesearch.adapter.ImageSearchAdapter


abstract class MainActivity : AppCompatActivity() {
    //뷰바인딩
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //프레그먼트
    private val imageSearchFragment by lazy { ImageSearchFragment() }

    //좋아요 누른 아이템들 저장하는 리스트
    var likedItems: ArrayList<SearchItemModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setFragment() //앱 시작시
        btnClick()
    }

    //버튼 누르면 프레그먼트가 보임
    fun btnClick() {
        //이미지 검색 버튼 누르면 fragment
        binding.btnImageSearch.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_search, ImageSearchFragment())
                .addToBackStack(null)// 뒤로가기 버튼으로 이전 Fragment로 돌아갈 수 있도록 스택에 추가
                .commit()
        }
        //보관함 버튼 누르면 fragment
        binding.btnMyBox.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_mybox, StorageFragment())
                .addToBackStack(null)
                .commit()
        }

    }

    //첫화면으로 띄우기 위함
    //이것도 해설과 다름 다시보기 !
    private fun setFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(imageSearchFragment.id, ImageSearchFragment(), "ImageSearchFragment")
            .addToBackStack("ImageSearchFragment")
            .commit()
    }

    //좋아요가 눌린 아이템을 likedItems 리스트에 추가하는 함수
    fun addLikedItem(item: SearchItemModel) {
        if (!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }

    //좋아요가 취소된 아이템을 likedItems 리스트에서 제거하는 함수
    fun removeLikedItem(item: SearchItemModel) {
        likedItems.remove(item)
    }
}