package com.example.imagesearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imagesearch.databinding.FragmentImageSearchBinding


class ImageSearchFragment : Fragment() {
    private lateinit var binding: FragmentImageSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


    fun search() {

    }
}