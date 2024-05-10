package com.example.imagesearch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearch.SearchItemModel
import com.example.imagesearch.data.ImageResponse
import com.example.imagesearch.databinding.FragmentStorageBinding
import com.example.imagesearch.databinding.ItemImageBinding

class StorageAdapter(var mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //뷰바인딩
    private lateinit var binding: FragmentStorageBinding

    //저장된 아이템들을 저장하는 리스트
    var saveItems = mutableListOf<SearchItemModel>()


    //onCreateViewHolder : 여기 어댑터에서 만든 뷰홀더를 상속받음 !
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageViewHolder {
        var binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //이미지 로딩 라이브러리(Glide)를 사용해 썸네일 이미지를 로드함
        //load,into 알아보기
        Glide.with(mContext)
            .load(saveItems[position].url)
            .into((holder as StorageViewHolder).iv_thum_image)

        holder.apply {
            tv_title.text = saveItems[position].title
            iv_like.visibility = View.GONE
            tv_datetiem.text = saveItems[position].dateTime //함수만들어야함
        }

        //holder..text = saveItems[position].title
    }

    override fun getItemCount(): Int {
        return saveItems.size
    }


    //저장 뷰홀더 만듦
    inner class StorageViewHolder(binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var iv_thum_image: ImageView = binding.itemImage
        var iv_like: ImageView = binding.itemLike
        var tv_title: TextView = binding.itemSitename
        var tv_datetiem: TextView = binding.itemDate
        var cl_item: ConstraintLayout = binding.clThumbItem

        init {
            //좋아요 아이콘 숨김
            iv_like.visibility = View.GONE

            //아이템 클릭 리스너 설정
            cl_item.setOnClickListener {
                val position = adapterPosition

                //포지션 알아보기
                if (position != RecyclerView.NO_POSITION) {
                    saveItems.removeAt(position)
                    notifyItemRemoved(position)

                }
            }
        }
    }
}