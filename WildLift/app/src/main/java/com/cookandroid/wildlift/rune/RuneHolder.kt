package com.cookandroid.wildlift.rune

import androidx.databinding.ViewDataBinding
import com.cookandroid.wildlift.base.BaseHolder

abstract class RuneHolder<T: ViewDataBinding>(binding: T) : BaseHolder<T, Rune>(binding) {
    init {
        itemView.setOnClickListener {
            RuneDialog(itemView.context, item).show()
        }
    }
}