package com.cookandroid.wildRift.Patch

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.cookandroid.wildRift.R

class DialogDevelopment(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_note, null)

        var txt = view.findViewById<TextView>(R.id.txtContent)
        var txtNoteTitle = view.findViewById<TextView>(R.id.txtNoteTitle)
        var txtLink = view.findViewById<TextView>(R.id.txtLink)
        txtNoteTitle.text = "개발자 정보"
        txt.text ="Development by YYW & KTJ\nDesgined by LHG\n앱 문의"
        txtLink.text = "https://open.kakao.com/o/gJtjhtJc"

        setContentView(view)

    }

}