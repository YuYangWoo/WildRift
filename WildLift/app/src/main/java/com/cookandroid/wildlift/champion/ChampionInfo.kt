package com.cookandroid.wildlift.champion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.wildlift.R

class ChampionInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_info)

        // ActionBar Title 변경
        title = resources.getString(R.string.champion_title)

    }
}