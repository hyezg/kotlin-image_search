package com.example.imagesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearch.data.ImageResponse
import com.example.imagesearch.databinding.FragmentStorageBinding
import com.example.imagesearch.databinding.ItemImageBinding

class StorageAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: FragmentStorageBinding

    var saveData = listOf<ImageResponse.Document>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return saveData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holder = holder as StorageViewHolder
        holder.bind(saveData[position])
    }


    class StorageViewHolder(private var binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //좋아요가  isvisible 상태이면 데이터 넣기?
        fun bind(images: ImageResponse.Document) {
            binding.apply {
                if (binding.itemHeart.isVisible) {
                    itemImage.text = images.thumbnailUrl
                    itemDate.text = images.datetime
                    itemSitename.text = images.displaySiteName
                }
            }
        }
    }
}