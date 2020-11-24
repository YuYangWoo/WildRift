package com.cookandroid.wildlift.rune

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.singleton.FirebaseSingleton
import kotlin.properties.Delegates

class RuneAdapter : RecyclerView.Adapter<RuneHolder>() {
    private val list = FirebaseSingleton.runeList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuneHolder {
        return RuneHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun onBindViewHolder(holder: RuneHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return list[position].name.hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.holder_rune
    }
}