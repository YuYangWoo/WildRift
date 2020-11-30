package com.cookandroid.wildlift

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.wildlift.Patch.WildNoteItem
import com.cookandroid.wildlift.rune.Rune
import kotlinx.android.synthetic.main.dialog_note.*

class DialogNote(context: Context, note: WildNoteItem) : Dialog(context) {
    private var note = note
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_note, null)

        var txt = view.findViewById<TextView>(R.id.txtContent)
       txt.text = note.content
        Log.d("test", note.content!!)
        setContentView(view)
    }
}