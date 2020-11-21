package com.cookandroid.wildlift.champion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
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

        Glide.with(this) // 띄어줄 뷰를 명시
            .load(champImg) // 이미지 주소
            .into(imgChampImage) // list_log의 imageView에 띄우기
        txtChampName.text = champName
        txtChampPosition.text = champPosition
    }
}