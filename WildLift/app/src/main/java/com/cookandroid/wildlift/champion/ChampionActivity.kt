package com.cookandroid.wildlift.champion

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.cookandroid.wildlift.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_champion.*

class ChampionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion)

        // ActionBar Title 변경
        title = resources.getString(R.string.champion_info_title)

        // 툴바 만들기
        val toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)

        // ActionBar Home 버튼 Enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 변수 Adapter에 ViewPagerAdapter를 객체화
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        // TabLayout에 ViewPager를 연동
        TabLayoutMediator(tabLyChampion, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = getString(adapter.fragmentList[position].tabTitle)
        }).attach()
    }

    // 검색 만들기
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, R.string.search, 0, R.string.search)?.setIcon(R.drawable.ic_search)?.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        return super.onCreateOptionsMenu(menu)
    }

    // ActionBar ItemSelected 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> { // 뒤로가기 버튼
                onBackPressed()
                return true
            }
//            R.string.search -> {
//                ChampionSearchDialog(this,).show()
//                true
//            }
        }
        return super.onOptionsItemSelected(item)
    }
}