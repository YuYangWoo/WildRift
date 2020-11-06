package com.cookandroid.wildlift.item

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.singleton.VolleyHttp
import org.json.JSONObject

class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemHolder>() {
    private val list: List<Item>

    init {
        setHasStableIds(true)

        list = ArrayList<Item>().apply {
            val request = StringRequest(
                Request.Method.GET, "http://ddragon.leagueoflegends.com/cdn/10.22.1/data/ko_KR/item.json",
                {
                    val json = JSONObject(it)
                    val items = json.getJSONObject("data")

                    for (key in items.keys()) {
                        add(ItemFactory.createFromJsonObject(key.toInt(), items.getJSONObject(key)))
                    }

                    notifyDataSetChanged()
                },
                {
                    Log.d("PASS", it.toString())
                }
            )

            VolleyHttp.getInstance(context).request(request)
        }
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