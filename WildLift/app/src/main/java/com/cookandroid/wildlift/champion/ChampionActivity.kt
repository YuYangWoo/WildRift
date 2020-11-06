package com.cookandroid.wildlift.champion

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.wildlift.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_champion.*

class ChampionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion)

        // ActionBar Title 변경
        title = "와일드리프트"

        // ActionBar Home 버튼 Enable
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 변수 Adapter에 ViewPagerAdapter를 객체화
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        for(i in 0..5) {
            adapter.addFragment(ChampionListFragment())
        }
        viewPager.adapter = adapter

        // TabLayout에 ViewPager를 연동
        TabLayoutMediator(tabLyChampion, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.champion_list_All    ) // 면적
                1 -> tab.text = resources.getString(R.string.champion_list_TOP    ) // 길이
                2 -> tab.text = resources.getString(R.string.champion_list_JUNGLE ) // 온도
                3 -> tab.text = resources.getString(R.string.champion_list_MID    ) // 부피
                4 -> tab.text = resources.getString(R.string.champion_list_BOTTOM ) // 무게
                5 -> tab.text = resources.getString(R.string.champion_list_SUPPORT) // 데이터
                else -> {
                    Log.d("Test", "Error!!")
                }
            }
        }).attach()
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