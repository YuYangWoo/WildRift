package com.cookandroid.wildlift.singleton

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.item.ItemHolder

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("itemImage")
    fun setItemImage(view: ImageView, holder: ItemHolder) {
        Glide.with(holder.itemView)
            .load(holder.item.getImageURL())
            .error(R.drawable.ic_menu_send)
            .into(view)
    }
}