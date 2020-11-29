package com.cookandroid.wildlift.Patch

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.Patch.PatchFactory.patchList
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.SplashActivity

class PatchAdapter : RecyclerView.Adapter<PatchAdapter.CustomViewHolder>() {
    var splash = SplashActivity()
    var patchList = splash.patchList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_main_patch, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.txtTitle.text = patchList[position].title
    }

    // ViewHolder를 만들어 list_champion.xml의 아이템들을 정의한다.
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txtTopic)

        init {
            itemView.setOnClickListener {
                var pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    var item = patchList[pos]

                    var intent = Intent(itemView.context, PatchWebView::class.java)
                    intent.putExtra("patchTitle", item.title)
                    intent.putExtra("patchUrl", item.url)

                    ContextCompat.startActivity(itemView.context, intent, null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return patchList.size
    }


}