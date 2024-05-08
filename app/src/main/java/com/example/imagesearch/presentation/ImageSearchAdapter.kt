package com.example.imagesearch.presentation

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearch.data.Image
import com.example.imagesearch.data.ImageItem
import com.example.imagesearch.data.SaveData
import com.example.imagesearch.databinding.ItemImageBinding

class ImageSearchAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: ItemImageBinding

    val images = mutableListOf<ImageItem>()

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
        return images.size  //리스트의 크기
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

        holder.bind(images[position])
    }

    //보관함으로 저장하는 함수
    //이미지를 눌렀을 때 보관함으로 저장됨
    //보관함에 저장되는 data List를 따로 만들어야하나?..
    /*fun save() {
        var saveList = mutableListOf<SaveData>()
        saveList.add(Image)
    }*/

    //item ViewHolder 생성
    //binding의 사진이 Image 데이터 클래스의 사진임
    class ImageViewHolder(private var binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(images: ImageItem) {
            binding.apply {
                itemImage.text = images.thumbnailUrl
                itemDate.text = images.date
                itemSitename.text = images.sitename
            }
        }
    }

    //storage viewholder 생성 ?
    class StorageViewHolder(private var binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(images: ImageItem) {
            binding.apply {
                if (binding.itemHeart.isVisible) {
                    itemImage.text = images.thumbnailUrl
                    itemDate.text = images.date
                    itemSitename.text = images.sitename
                }
            }
        }
    }

}