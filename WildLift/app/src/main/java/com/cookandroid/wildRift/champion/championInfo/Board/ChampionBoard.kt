package com.cookandroid.wildRift.champion.championInfo.Board

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.wildRift.R
import kotlinx.android.synthetic.main.activity_champion_board.*
import kotlinx.android.synthetic.main.activity_champion_info.*

class ChampionBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_board)

        var champName = intent.getStringExtra("championName")
        setSupportActionBar(toolbar2)

        // ActionBar Home 버튼 Enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "$champName" + "의 게시판"

        btnWrite.setOnClickListener {
            startActivity(Intent(this,BoardWrite::class.java))
        }
    }

    // ActionBar ItemSelected 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> { // 뒤로가기 버튼
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}