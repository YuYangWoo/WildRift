package com.cookandroid.wildRift.rune

import androidx.databinding.ViewDataBinding
import com.cookandroid.wildRift.base.BaseHolder

abstract class RuneHolder<T: ViewDataBinding>(binding: T) : BaseHolder<T, Rune>(binding) {
    init {
        itemView.setOnClickListener {
            RuneDialog(itemView.context, item).show()
        }
    }
}