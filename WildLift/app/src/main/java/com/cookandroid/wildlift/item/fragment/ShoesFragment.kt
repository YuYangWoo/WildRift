package com.cookandroid.wildlift.item.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cookandroid.wildlift.R

class ShoesFragment : ItemFragment() {
    override val tabTitle: Int
        get() = R.string.shoes

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.middleTextView.text = getString(R.string.magic_shoes)

        return view
    }
}