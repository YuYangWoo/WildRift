package com.cookandroid.wildlift.spell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.R
import kotlinx.android.synthetic.main.activity_spell.*

class SpellActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var recyclerViewAdapter = SpellAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spell)

        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerViewAdapter
    }
}