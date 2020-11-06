package com.cookandroid.wildlift.item

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.databinding.DialogItemBinding

class ItemDialog(context: Context, val item: Item) : Dialog(context) {
    private lateinit var binding: DialogItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_item, null, false)
        binding.dialog = this
        setContentView(binding.root)
    }
}