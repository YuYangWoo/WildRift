package com.cookandroid.wildlift

import android.os.Bundle
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.databinding.ActivityRunesSpellBinding

class RunesActivity : BaseActivity<ActivityRunesSpellBinding>(R.layout.activity_runes_spell) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initActionBar()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
    }
}