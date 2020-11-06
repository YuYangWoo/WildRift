package com.cookandroid.wildlift.item.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseDialog
import com.cookandroid.wildlift.databinding.DialogItemSearchBinding
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.item.ItemAdapter
import com.cookandroid.wildlift.item.ItemTestDB

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
                    for (item in ItemTestDB.list) {
                        if (item.name.contains(s, true)) {
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