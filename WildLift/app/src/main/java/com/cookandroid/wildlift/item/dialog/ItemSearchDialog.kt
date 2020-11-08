package com.cookandroid.wildlift.item.dialog

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseDialog
import com.cookandroid.wildlift.databinding.DialogItemSearchBinding
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.item.ItemAdapter
import com.cookandroid.wildlift.item.ItemFactory
import com.cookandroid.wildlift.singleton.FirebaseSingleton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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