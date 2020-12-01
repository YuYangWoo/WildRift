package com.cookandroid.wildRift.item.dialog

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.base.BaseDialog
import com.cookandroid.wildRift.databinding.DialogItemSearchBinding
import com.cookandroid.wildRift.item.Item
import com.cookandroid.wildRift.item.ItemAdapter
import com.cookandroid.wildRift.singleton.FirebaseSingleton

class ItemSearchDialog(context: Context) : BaseDialog<DialogItemSearchBinding>(context, R.layout.dialog_item_search) {
    private val adapter by lazy { ItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s == null || s.isEmpty()) {
                    adapter.list = listOf()
                    return
                }

                ArrayList<Item>().apply {
                    for (item in FirebaseSingleton.itemList) {
                        if (item.name.contains(s)) {
                            add(item)
                        }
                    }
                }.also {
                    adapter.list = it
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        with(binding.recyclerView) {
            adapter = this@ItemSearchDialog.adapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }
}