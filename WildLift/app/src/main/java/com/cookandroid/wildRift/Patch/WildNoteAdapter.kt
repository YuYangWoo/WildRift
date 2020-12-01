package com.cookandroid.wildRift.Patch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildRift.Patch.PatchFactory.noteList
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.SplashActivity

class WildNoteAdapter : RecyclerView.Adapter<WildNoteAdapter.CustomViewHolder>() {
    var splash = SplashActivity()
    var noteList = splash.noteList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_main_patch, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.txtTitle.text = noteList[position].title
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txtTopic)

        init {
            itemView.setOnClickListener {
                var pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    var item = noteList[pos]
                    DialogNote(itemView.context, item).show()
                }


            }
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

}