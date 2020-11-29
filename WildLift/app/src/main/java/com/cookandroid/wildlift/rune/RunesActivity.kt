package com.cookandroid.wildlift.rune

import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.databinding.ActivityRunesSpellBinding
import com.cookandroid.wildlift.singleton.FirebaseSingleton

class RunesActivity : BaseActivity<ActivityRunesSpellBinding>(R.layout.activity_runes_spell) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun init() {
        initActionBar()
        initMainRuneRecyclerView()
        initControlRuneRecyclerView()
        initResolutionRuneRecyclerView()
        initInspirationRecyclerView()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "아이템 정보"
    }

    private fun initMainRuneRecyclerView() {
        with(binding.mainRuneRecyclerView) {
            layoutManager = GridLayoutManager(this@RunesActivity, 4)
            adapter = RuneAdapter().apply {
                val list = ArrayList<Rune>()
                FirebaseSingleton.runeList.forEach { rune ->
                    if (rune.type == "핵심") {
                        list.add(rune)
                    }
                }

                this.list = list
            }
        }
    }

    private fun initControlRuneRecyclerView() {
        with(binding.controlRuneRecyclerView) {
            layoutManager = GridLayoutManager(this@RunesActivity, 5)
            adapter = RuneAdapter().apply {
                val list = ArrayList<Rune>()
                FirebaseSingleton.runeList.forEach { rune ->
                    if (rune.type == "지배") {
                        list.add(rune)
                    }
                }

                this.list = list
            }
        }
    }

    private fun initResolutionRuneRecyclerView() {
        with(binding.resolutionRuneRecyclerView) {
            layoutManager = GridLayoutManager(this@RunesActivity, 5)
            adapter = RuneAdapter().apply {
                val list = ArrayList<Rune>()
                FirebaseSingleton.runeList.forEach { rune ->
                    if (rune.type == "결의") {
                        list.add(rune)
                    }
                }

                this.list = list
            }
        }
    }

    private fun initInspirationRecyclerView() {
        with(binding.inspirationRuneRecyclerView) {
            layoutManager = GridLayoutManager(this@RunesActivity, 5)
            adapter = RuneAdapter().apply {
                val list = ArrayList<Rune>()
                FirebaseSingleton.runeList.forEach { rune ->
                    if (rune.type == "영감") {
                        list.add(rune)
                    }
                }

                this.list = list
            }
        }
    }
}