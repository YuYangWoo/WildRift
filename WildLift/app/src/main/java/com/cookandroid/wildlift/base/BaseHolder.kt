package com.cookandroid.wildlift.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder<T: ViewDataBinding, E: Any>(protected val binding: T) : RecyclerView.ViewHolder(binding.root) {
    protected lateinit var item: E

    open fun bind(item: E) {
        this.item = item
        binding.executePendingBindings()
    }
}