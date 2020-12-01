package com.cookandroid.wildRift.item

import com.cookandroid.wildRift.base.BaseHolder
import com.cookandroid.wildRift.databinding.HolderItemBinding
import com.cookandroid.wildRift.item.dialog.ItemInformationDialog

class ItemHolder(binding: HolderItemBinding) : BaseHolder<HolderItemBinding, Item>(binding) {
    init {
        itemView.setOnClickListener {
            ItemInformationDialog(itemView.context, item).show()
        }
    }
}