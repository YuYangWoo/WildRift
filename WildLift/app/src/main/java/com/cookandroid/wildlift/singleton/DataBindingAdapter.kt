package com.cookandroid.wildlift.singleton

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.item.ItemHolder

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("itemImage")
    fun setItemImage(view: ImageView, item: Item) {
        Glide.with(view.context)
            .load(item.getImageURL())
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("toString")
    fun setText(view: TextView, item: Int) {
        view.text = item.toString()
    }
}