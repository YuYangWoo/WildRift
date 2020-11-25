package com.cookandroid.wildlift.champion

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R

class ChampionAdapter constructor() : RecyclerView.Adapter<ChampionAdapter.CustomViewHolder>(),
    Filterable {
    var championList = ArrayList<ChampionItem>()
    var filteredChampionList = ArrayList<ChampionItem>()

    constructor(championList: ArrayList<ChampionItem>) : this() {
        this.championList = championList
        this.filteredChampionList = championList
    }

    // 실제 리스트뷰가 어댑터에 연결된 다음에 뷰 홀더를 최초로 만들어낸다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_champion, parent, false)
        return CustomViewHolder(view)
    }

    // ImageView를 Glide를 사용하여 로드하고 info와 time도 대입시킨다.
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide.with(holder.itemView) // 띄어줄 뷰를 명시
            .load(filteredChampionList[position].image) // 이미지 주소
            .into(holder.photo) // list_log의 imageView에 띄우기

        holder.txtChampionName.text = filteredChampionList[position].name
        holder.txtChampionPosition.text = filteredChampionList[position].position
        holder.txtChampionIP.text = filteredChampionList[position].ip
        holder.txtChampionRp.text = filteredChampionList[position].rp
    }

    // ViewHolder를 만들어 list_champion.xml의 아이템들을 정의한다.
    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.imgChampion)
        var txtChampionName: TextView = itemView.findViewById(R.id.txtName)
        var txtChampionPosition: TextView = itemView.findViewById(R.id.txtPosition)
        var txtChampionIP: TextView = itemView.findViewById(R.id.txtIP)
        var txtChampionRp: TextView = itemView.findViewById(R.id.txtRp)

        init {
            itemView.setOnClickListener {
                var pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    var item = filteredChampionList[pos]
                    var intent = Intent(itemView.context, ChampionInfo::class.java)
                    intent.putExtra("championImage", item.image)
                    intent.putExtra("championName", item.name)
                    intent.putExtra("championPosition", item.position)
                    intent.putExtra("championIP", item.ip)
                    intent.putExtra("championRp", item.rp)
                    intent.putExtra("championEngName", item.engName)

                    ContextCompat.startActivity(itemView.context, intent, null)
                }
            }
        }
    }

    // arrayList의 크기를 가져온다
    override fun getItemCount(): Int {
        return filteredChampionList.size
    }

    // 챔피언 검색기능 필터링
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var key = constraint.toString()
                if (key.isEmpty()) {
                    filteredChampionList = championList
                } else {
                    var lsFiltered = ArrayList<ChampionItem>()
                    for (row in championList) {
                        if (row.name!!.toLowerCase().contains(key.toLowerCase())) {
                            lsFiltered.add(row)
                        }
                    }
                    filteredChampionList = lsFiltered
                }

                var filterResults = FilterResults()
                filterResults.values = filteredChampionList

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredChampionList = results!!.values as ArrayList<ChampionItem>
                notifyDataSetChanged()
            }

        }
    }

}