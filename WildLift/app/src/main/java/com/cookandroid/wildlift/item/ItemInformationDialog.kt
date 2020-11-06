package com.cookandroid.wildlift.item

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.databinding.DialogItemInformationBinding

class ItemInformationDialog(context: Context, val item: Item) : Dialog(context) {
    private lateinit var binding: DialogItemInformationBinding

    companion object {
        var instance: ItemInformationDialog? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_item_information, null, false)

        with(binding.intoRecyclerView) {
            adapter = ItemAdapter().apply {
                list = item.into
            }

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            if (item.into.isEmpty()) {
                binding.intoItemTextView.visibility = View.GONE
            }
        }

        with(binding.fromRecyclerView) {
            adapter = ItemAdapter().apply {
                list = item.from
            }

            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            if (item.from.isEmpty()) {
                binding.fromItemTextView.visibility = View.GONE
            }
        }

        binding.dialog = this
        setContentView(binding.root)

        instance?.cancel()
        instance = this
    }
}