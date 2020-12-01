package com.cookandroid.wildRift.Patch

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.cookandroid.wildRift.R

class DialogNote(context: Context, note: WildNoteItem?) : Dialog(context) {

    private var note = note
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_note, null)

        var txt = view.findViewById<TextView>(R.id.txtContent)
        var txtNoteTitle = view.findViewById<TextView>(R.id.txtNoteTitle)

        txtNoteTitle.text ="공지사항"
        txt!!.text = note!!.content


        setContentView(view)
    }
}