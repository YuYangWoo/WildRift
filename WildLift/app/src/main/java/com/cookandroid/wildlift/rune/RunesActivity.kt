package com.cookandroid.wildlift.rune

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.databinding.ActivityRunesSpellBinding

class RunesActivity : BaseActivity<ActivityRunesSpellBinding>(R.layout.activity_runes_spell) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initActionBar()
        initRecyclerView()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@RunesActivity)
            adapter = RuneAdapter()
        }
    }
}