package com.example.imagesearch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imagesearch.data.Image
import com.example.imagesearch.databinding.ActivityMainBinding
import com.example.imagesearch.presentation.ImageSearchAdapter

//import com.example.imagesearch.databinding.ItemImageBinding
//import com.example.imagesearch.presentation.ImageSearchAdapter

abstract class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val imageSearchFragment by lazy { ImageSearchFragment() }
    private val imageSearchAdapter = ImageSearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnClick()
    }

    fun btnClick() {
        //이미지 검색 버튼 누르면 fragment
        binding.btnImageSearch.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_search, ImageSearchFragment())
            fragmentTransaction.commit()
        }
        //보관함 버튼 누르면 fragment
        binding.btnMyBox.setOnClickListener {
            val fragmentTransaction2 = supportFragmentManager.beginTransaction()
            fragmentTransaction2.replace(R.id.fragment_mybox, StorageFragment())
            fragmentTransaction2.commit()
        }

        //다른 시도 (이미지 검색 버튼 눌렀을 때 fragment 실행
        /*binding.btnImageSearch.setOnClickListener {
            val fragment = supportFragmentManager.fragmentFactory.instantiate(
                classLoader,
                ImageSearchFragment::class.java.name
            )
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_search,
                    fragment
                )
                .addToBackStack(null) // 뒤로가기 버튼으로 이전 Fragment로 돌아갈 수 있도록 스택에 추가
                .commit()
        }*/
    }
}