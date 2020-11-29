package com.cookandroid.wildlift.spell

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.SplashActivity

class SpellAdapter constructor() : RecyclerView.Adapter<SpellAdapter.CustomViewHolder>() {
    var splash = SplashActivity()
    var spell = splash.spellList
    // 데이터
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellAdapter.CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_spell, parent, false)
        return CustomViewHolder(view)
    }
    // 데이터 대입
    override fun onBindViewHolder(holder: SpellAdapter.CustomViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(spell[position].image)
            .into(holder.image)
        holder.txtTopic.text = spell[position].topic
        holder.txtCool.text = spell[position].cool
        holder.txtSpellName.text = spell[position].name
    }
    // 데이터 개수
    override fun getItemCount(): Int {
        return spell.size
    }

    // ViewHolder를 만들어 list_champion.xml의 아이템들을 정의한다.
    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.imgSpell)!!
        var txtTopic = itemView.findViewById<TextView>(R.id.txtTopic)!!
        var txtCool = itemView.findViewById<TextView>(R.id.txtCool)!!
        var txtSpellName = itemView.findViewById<TextView>(R.id.txtSpellName)!!

    }
}