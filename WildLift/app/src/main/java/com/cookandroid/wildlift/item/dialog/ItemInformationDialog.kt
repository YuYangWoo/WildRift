package com.cookandroid.wildlift.item.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseDialog
import com.cookandroid.wildlift.databinding.DialogItemInformationBinding
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.item.ItemAdapter
import com.cookandroid.wildlift.singleton.FirebaseSingleton

class ItemInformationDialog(context: Context, val item: Item) : BaseDialog<DialogItemInformationBinding>(context, R.layout.dialog_item_information) {
    companion object {
        var instance: ItemInformationDialog? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding.intoRecyclerView) {
            adapter = ItemAdapter().apply {
                val list = ArrayList<Item>()
                for (name in item.into) {
                    for (item in FirebaseSingleton.itemList) {
                        if (item.name == name) {
                            list.add(item)
                        }
                    }
                }

                this.list = list
            }

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            if (item.into.isEmpty()) {
                binding.intoItemTextView.visibility = View.GONE
            }
        }

        with(binding.fromRecyclerView) {
            adapter = ItemAdapter().apply {
                val list = ArrayList<Item>()

                for (name in item.from) {
                    for (item in FirebaseSingleton.itemList) {
                        if (item.name == name) {
                            list.add(item)
                        }
                    }
                }

                this.list = list
            }

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            if (item.from.isEmpty()) {
                binding.fromItemTextView.visibility = View.GONE
            }
        }

        instance?.cancel()
        instance = this
    }
}