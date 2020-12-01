package com.cookandroid.wildRift.item.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.base.BaseDialog
import com.cookandroid.wildRift.databinding.DialogItemInformationBinding
import com.cookandroid.wildRift.item.Item
import com.cookandroid.wildRift.item.ItemAdapter
import com.cookandroid.wildRift.singleton.FirebaseSingleton
import kotlin.properties.Delegates

class ItemInformationDialog(context: Context, val item: Item) : BaseDialog<DialogItemInformationBinding>(context, R.layout.dialog_item_information) {
    companion object {
        var instance by Delegates.observable<ItemInformationDialog?>(null) { _, oldValue, _ ->
            oldValue?.cancel()
        }
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

        instance = this
    }
}