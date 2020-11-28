package com.cookandroid.wildlift

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LotationAdapter constructor(): RecyclerView.Adapter<LotationAdapter.CustomViewHolder>() {
    private var list = ArrayList<String>()

    constructor(list:ArrayList<String>) :this() {
        this.list = list
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_spell_rune, parent, false)
        return CustomViewHolder(view)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position]).into(holder.img)
    }

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var img = itemView.findViewById<ImageView>(R.id.imgItem)
    }
    override fun getItemCount(): Int {
      return list.size
    }


}