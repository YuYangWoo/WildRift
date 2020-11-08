package com.cookandroid.wildlift.singleton

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.item.Item

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("itemImage")
    fun setItemImage(view: ImageView, item: Item) {
        Glide.with(view.context)
            .load(item.imageURL)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("cost")
    fun setTotalCost(view: TextView, item: Item) {
        view.text = "${view.context.getString(R.string.total_cost)} : ${String.format("%,d", item.cost)} "
    }
}