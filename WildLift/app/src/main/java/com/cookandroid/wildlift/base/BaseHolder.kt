package com.cookandroid.wildlift.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.BR

abstract class BaseHolder<T: ViewDataBinding, E: Any>(protected val binding: T) : RecyclerView.ViewHolder(binding.root) {
    lateinit var item: E

    open fun bind(item: E) {
        this.item = item
        binding.setVariable(BR.holder, this)
    }
}