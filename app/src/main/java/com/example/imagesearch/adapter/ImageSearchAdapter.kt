package com.example.imagesearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearch.data.ImageResponse
import com.example.imagesearch.databinding.ItemImageBinding

class ImageSearchAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //뷰바인딩
    private lateinit var binding: ItemImageBinding

    val imageData = listOf<ImageResponse.Document>()

    //클릭 이벤트 추가 부분
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageData.size  //리스트의 크기
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //클릭 이벤트 추가 부분
        //item 클릭하면 하트 이미지가 보임?? -> invisible을 visible 로 변경
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position) //아이템 클릭시 onClick 함수 실행됨.
            if (!binding.itemHeart.isVisible) {
                binding.itemHeart.isVisible = true
            }
        }
        val holder = holder as ImageViewHolder
        holder.bind(imageData[position])
    }


    //item ViewHolder 생성
    class ImageViewHolder(private var binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(images: ImageResponse.Document) {
            binding.apply {
                itemImage.text = images.thumbnailUrl
                itemDate.text = images.datetime
                itemSitename.text = images.displaySiteName
            }
        }
    }

}