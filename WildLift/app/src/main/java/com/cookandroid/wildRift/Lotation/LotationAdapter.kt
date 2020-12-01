package com.cookandroid.wildRift.Lotation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildRift.Lotation.LotationFactory.lotationList
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.champion.ChampionFactory
import com.cookandroid.wildRift.champion.championInfo.ChampionInfo

class LotationAdapter constructor() : RecyclerView.Adapter<LotationAdapter.CustomViewHolder>() {
    var lotationlist = ArrayList<String>()

    constructor(list: ArrayList<String>) : this() {
        this.lotationlist = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_spell_rune, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide.with(holder.itemView).load(lotationlist[position]).into(holder.img)
    }

    class CustomViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var img = itemView.findViewById<ImageView>(R.id.imgItem)

        init {
            itemView.setOnClickListener {
                var pos = adapterPosition

                if (pos != RecyclerView.NO_POSITION) {
                    var a = lotationList[pos].name
                    for (j in ChampionFactory.championList) {
                        if (a == j.name) {
                            var intent = Intent(itemView.context, ChampionInfo::class.java)
                            intent.putExtra("championImage", j.image)
                            intent.putExtra("championName", j.name)
                            intent.putExtra("championPosition", j.position)
                            intent.putExtra("championIP", j.ip)
                            intent.putExtra("championRp", j.rp)
                            intent.putExtra("championEngName", j.engName)
                            ContextCompat.startActivity(itemView.context, intent, null)
                        }
                    }

                }

            }
        }

    }

    override fun getItemCount(): Int {
        return lotationlist.size
    }


}