package com.cookandroid.wildlift.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.cookandroid.wildlift.BR
import com.cookandroid.wildlift.R

abstract class BaseDialog<T: ViewDataBinding>(context: Context, private val layoutId: Int) : Dialog(context) {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, null, false)
        binding.setVariable(BR.dialog, this)
        setContentView(binding.root)
    }
}