package com.cookandroid.wildlift.singleton

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.rune.Rune
import com.cookandroid.wildlift.spell.SpellItem

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("itemImage")
    fun setItemImage(view: ImageView, item: Item) {
        Glide.with(view.context)
            .load(item.imageURL)
            .placeholder(R.drawable.ic_coin)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("itemImage")
    fun setRuneImage(view: ImageView, rune: Rune) {
        Glide.with(view.context)
            .load(rune.image)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("itemImage")
    fun setRuneImage(view: ImageView, spell: SpellItem) {
        Glide.with(view.context)
            .load(spell.image)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("cost")
    fun setTotalCost(view: TextView, item: Item) {
        view.text = "${view.context.getString(R.string.total_cost)} : ${String.format("%,d", item.cost)} "
    }
}