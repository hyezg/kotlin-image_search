package com.example.imagesearch.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesearch.SearchItemModel
import com.example.imagesearch.databinding.FragmentImageSearchBinding
import com.example.imagesearch.adapter.ImageSearchAdapter


class ImageSearchFragment : Fragment() {
    //뷰바인딩
    private var _binding: FragmentImageSearchBinding? = null
    private val binding get() = _binding!!

    //onAttach에서 context 사용함 -> context 무엇인지 알아보기
    private lateinit var mContext: Context

    //어뎁터
    private lateinit var adapter: ImageSearchAdapter

    //리사이클러뷰 그리드로
    private lateinit var gridmanager: StaggeredGridLayoutManager

    //보관함에 저장될 데이터 리스트
    private var searchItems: ArrayList<SearchItemModel> = ArrayList()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageSearchBinding.inflate(inflater, container, false)

        setupViews()

        return binding.root
    }

    //화면의 초기 설정하는 메서드
    private fun setupViews() {
        //리사이클러뷰 그리드로 설정하기
        gridmanager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvSearchResult.layoutManager = gridmanager

        //어뎁터에 context
        adapter = ImageSearchAdapter(mContext)
        binding.rvSearchResult.adapter = adapter

        //최근 검색어 가져와 EditText에 설정하기

    }

    //gridmanager 공부, staggeredgridlayout


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //onCreate 없어도 되는듯? -> 프레그먼트 생명주기 공부하기
}