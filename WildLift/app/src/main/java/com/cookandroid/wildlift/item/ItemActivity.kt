package com.cookandroid.wildlift.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.databinding.ActivityItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class ItemActivity : BaseActivity<ActivityItemBinding>(R.layout.activity_item) {
    private val model by lazy { ViewModelProvider(this).get(ItemActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initActionBar()
        initViewPager()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initViewPager() {
        with(binding) {
            viewPager.adapter = object : FragmentStateAdapter(this@ItemActivity) {
                override fun getItemCount(): Int {
                    return model.fragments.size
                }

                override fun createFragment(position: Int): Fragment {
                    return model.fragments[position]
                }
            }

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = getString(model.fragments[position].tabTitle)
            }.attach()
        }
    }

    class ItemActivityViewModel : ViewModel() {
        val fragments by lazy {
            arrayOf(
                ItemFragment(R.string.physics), ItemFragment(R.string.magic),
                ItemFragment(R.string.defense), ItemFragment(R.string.shoes)
            )
        }
    }
}