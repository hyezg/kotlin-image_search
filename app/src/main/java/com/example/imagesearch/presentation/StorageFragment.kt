package com.example.imagesearch.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesearch.SearchItemModel
import com.example.imagesearch.adapter.StorageAdapter
import com.example.imagesearch.databinding.FragmentStorageBinding


class StorageFragment : Fragment() {
    private lateinit var mContext: Context

    //뷰바인딩
    private var _binding: FragmentStorageBinding? = null
    private val binding get() = _binding!!

    //어댑터
    private lateinit var adapter: StorageAdapter

    //좋아요를 받은 항목을 저장하는 리스트
    private var likedItems: List<SearchItemModel> = listOf()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStorageBinding.inflate(inflater, container, false)

        //MainActivity로부터 좋아요 받은 항목 가져옴
        val mainActivity = activity as MainActivity
        likedItems = mainActivity.likedItems

        Log.d("StorageFragment", "likedItems size = ${likedItems.size}")

        adapter = StorageAdapter(mContext).apply {
            saveItems = likedItems.toMutableList()
        }

        //바인딩 및 리사이클러뷰 설정
        _binding = FragmentStorageBinding.inflate(inflater, container, false).apply {
            rvStorage.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rvStorage.adapter = adapter
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}