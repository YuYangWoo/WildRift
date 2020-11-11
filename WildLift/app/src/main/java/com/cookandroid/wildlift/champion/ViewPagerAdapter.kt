
package com.cookandroid.wildlift.champion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cookandroid.wildlift.R

class ViewPagerAdapter(fragmentManager: FragmentManager?, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager!!, lifecycle) {

    // Fragment를 담는 list 생성
    val fragmentList = arrayOf(
        ChampionListFragment(R.string.champion_list_All),ChampionListFragment(R.string.champion_list_ASSASSIN), ChampionListFragment(R.string.champion_list_WIZARD),
        ChampionListFragment(R.string.champion_list_WARRIOR), ChampionListFragment(R.string.champion_list_BOTTOM), ChampionListFragment(R.string.champion_list_SUPPORT), ChampionListFragment(R.string.champion_list_tanker)
    )

    // Fragment의 위치를 반환하는 함수
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }


    // FragmentList의 크기를 반환하는 함수
    override fun getItemCount(): Int {
        return fragmentList.size
    }

}