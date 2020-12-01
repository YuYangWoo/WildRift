package com.cookandroid.wildRift.rune

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildRift.R
import kotlin.properties.Delegates

class RuneAdapter : RecyclerView.Adapter<RuneHolder<*>>() {
    var list by Delegates.observable(listOf<Rune>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuneHolder<*> {
        return when(viewType) {
            R.layout.holder_main_rune -> {
                MainRuneHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
            }
            else -> {
                SubRuneHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RuneHolder<*>, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return list[position].name.hashCode().toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return when(list[position].type) {
            "핵심" -> {
                R.layout.holder_main_rune
            }
            else -> {
                R.layout.holder_sub_rune
            }
        }
    }
}