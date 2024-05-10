package com.example.imagesearch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagesearch.SearchItemModel
import com.example.imagesearch.Utils.getDateFromTimestampWithFormat
import com.example.imagesearch.databinding.ItemImageBinding
import com.example.imagesearch.presentation.MainActivity

//이미지 검색 결과를 표시하는 어댑터 클래스
class ImageSearchAdapter(private val mContext: Context) :
    RecyclerView.Adapter<ImageSearchAdapter.ItemViewHolder>() {

    //val imageData = listOf<ImageResponse.Document>()

    //isLike 포함된 데이터 클래스 가져옴
    var items = ArrayList<SearchItemModel>()

    //아이템 목록을 초기화하는 메서드
    fun clearItem() {
        items.clear()  //데이터 지움
        notifyDataSetChanged() //데이터 새로 고침
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    //onBindViewHodler에서 뭐 하는지 찾기
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        Glide.with(mContext)
            .load(currentItem.url)
            .into(holder.iv_thum_image)

        holder.apply {
            iv_like.visibility = if (currentItem.isLike) View.VISIBLE else View.INVISIBLE
            tv_title.text = currentItem.title
            holder.tv_datetiem.text = getDateFromTimestampWithFormat(
                currentItem.dateTime,
                "yyyy-MM-dd'T'HH:mm.SSS+09:00",
                "yyyy--MM-dd HH:mm:ss"
            )
        }
    }

    override fun getItemCount(): Int = items.size


    //item ViewHolder 생성
    // 각 항목 클릭 시 발생하는 이벤트를 처리하는 메서드
    inner class ItemViewHolder(binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        var iv_thum_image = binding.itemImage
        var iv_like = binding.itemLike
        var tv_title = binding.itemSitename
        var tv_datetiem = binding.itemDate
        var cl_thumb_item = binding.clThumbItem //전체 레이아웃 이름

        //this의 의미 알아보기
        init {
            iv_like.visibility = View.GONE
            iv_thum_image.setOnClickListener(this)
            cl_thumb_item.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            //position알아보기. takeIf
            val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            val item = items[position]

            item.isLike != item.isLike

            //아이템이 클릭되서 좋아요가 true라면 add 아니면 remove ?
            if (item.isLike) {
                (mContext as MainActivity).addLikedItem(item)
            } else {
                (mContext as MainActivity).removeLikedItem(item)
            }
            notifyItemChanged(position)
        }


    }

}