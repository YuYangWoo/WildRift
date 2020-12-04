package com.cookandroid.wildRift

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_law.*
import kotlinx.android.synthetic.main.activity_skill_skin.*

class Law : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_law)

        // 툴바 만들기
        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)
        title = "개인정보처리방침"

        // ActionBar Home 버튼 Enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // 웹 뷰 적용
        webView1.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        webView1.loadUrl("https://developeryyw.blogspot.com/2020/12/blog-post.html")

    }

    override fun onBackPressed() {
        if (webView1.canGoBack()) {
            webView1.goBack()
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