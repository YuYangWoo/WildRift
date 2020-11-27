package com.cookandroid.wildlift.champion.championInfo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.singleton.FirebaseSingleton

class ItemAdapter constructor() : RecyclerView.Adapter<ItemAdapter.CustomViewHolder>() {

    var itemList = ArrayList<String>()

    constructor(itemList: ArrayList<String>) : this() {
        this.itemList = itemList
        Log.d("test", this.itemList.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_spell_rune, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.CustomViewHolder, position: Int) {
        Glide.with(holder.itemView) // 띄어줄 뷰를 명시
            .load(itemList[position]) // 이미지 주소
            .into(holder.img) // list_log의 imageView에 띄우기
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.imgItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}