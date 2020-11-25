package com.cookandroid.wildlift.champion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.champion.championInfo.ChampionSkillSkin
import com.cookandroid.wildlift.champion.championInfo.ChampionUniverse
import kotlinx.android.synthetic.main.activity_champion_info.*

class ChampionInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_info)

        // ActionBar Title 변경
        title = resources.getString(R.string.champion_info_title)

        var champImg = intent.getStringExtra("championImage")
        var champName = intent.getStringExtra("championName")
        var champPosition = intent.getStringExtra("championPosition")
        var champEngName = intent.getStringExtra("championEngName")

        Glide.with(this) // 띄어줄 뷰를 명시
            .load(champImg) // 이미지 주소
            .into(imgChampImage) // list_log의 imageView에 띄우기
        txtChampName.text = champName
        txtChampPosition.text = champPosition

        // 스킬/스킨 버튼
        btnSkillSkin.setOnClickListener {
            var intent = Intent(this,ChampionSkillSkin::class.java)
            intent.putExtra("championEngName", champEngName)
            startActivity(intent)
        }
        // 챔피언 유니버스 버튼
        btnUniverse.setOnClickListener {
            var intent = Intent(this,ChampionUniverse::class.java)
            intent.putExtra("championEngName", champEngName)
            startActivity(intent)
        }
    }
}