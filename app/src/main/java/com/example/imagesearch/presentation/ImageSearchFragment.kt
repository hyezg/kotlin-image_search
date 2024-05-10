package com.example.imagesearch.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.imagesearch.databinding.FragmentImageSearchBinding
import com.example.imagesearch.adapter.ImageSearchAdapter


class ImageSearchFragment : Fragment() {
    //뷰바인딩
    private var _binding: FragmentImageSearchBinding? = null
    private val binding get() = _binding!!

    //뷰모델. (gradle 에 추가해야함)
    private val searchViewModel: SearchViewModel by activityViewModels()

    //어뎁터
    private val favoriteListAdapter: ImageSearchAdapter by lazy {
        ImageSearchAdapter()
    }

    //액티비티에서 접근할 수 있도록
    companion object {
        fun newInstance() = StorageFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}