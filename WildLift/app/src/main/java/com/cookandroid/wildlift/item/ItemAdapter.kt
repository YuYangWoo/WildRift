package com.cookandroid.wildlift.item

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.StringRequest
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.singleton.VolleyHttp
import org.json.JSONObject
import kotlin.properties.Delegates

class ItemAdapter : RecyclerView.Adapter<ItemHolder>() {
    var list by Delegates.observable(listOf<Item>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return list[position].id.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.holder_item
    }

}