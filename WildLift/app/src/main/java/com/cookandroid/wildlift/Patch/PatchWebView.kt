package com.cookandroid.wildlift.Patch

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.cookandroid.wildlift.R
import kotlinx.android.synthetic.main.activity_skill_skin.*

class PatchWebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_patch_main)

        var patchTitle = intent.getStringExtra("patchTitle")
        var patchUrl  = intent.getStringExtra("patchUrl")
        title = patchTitle

        // 툴바 만들기
        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)

        // ActionBar Home 버튼 Enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 웹 뷰 적용
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        webView.loadUrl("$patchUrl")
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