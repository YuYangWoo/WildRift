package com.cookandroid.wildlift.champion.championInfo

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.cookandroid.wildlift.R
import kotlinx.android.synthetic.main.activity_skill_skin.*

class ChampionUniverse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_universe)
        // ActionBar Title 변경
        title = "챔피언 유니버스"

        // 툴바 만들기
        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)

        var champEngName = intent.getStringExtra("championEngName")

        // ActionBar Home 버튼 Enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        webView.loadUrl("https://universe.leagueoflegends.com/ko_KR/champion/$champEngName/")

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
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