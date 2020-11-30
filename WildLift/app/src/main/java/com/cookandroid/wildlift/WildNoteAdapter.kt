package com.cookandroid.wildlift

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.Patch.PatchAdapter
import com.cookandroid.wildlift.Patch.PatchFactory.noteList
import com.cookandroid.wildlift.Patch.PatchWebView
import com.google.android.material.internal.ContextUtils.getActivity

class WildNoteAdapter: RecyclerView.Adapter<WildNoteAdapter.CustomViewHolder>() {
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
               var item  = noteList[pos]
//                    var intent = Intent(itemView.context, DialogNote::class.java)
//                    intent.putExtra("content", item.content)
                    //                    ContextCompat.startActivity(itemView.context, intent, null)
//                    val inflater = getSystemService() as LayoutInflater
//                    val view = inflater.inflate(R.layout.dialog_note, null)

                    DialogNote(itemView.context, item).show()


//                    val alertDialog = AlertDialog.Builder(itemView.context).create()
//                    alertDialog.setView(view)
//                    alertDialog.show()
                }


            }
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

}