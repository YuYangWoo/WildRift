package com.cookandroid.wildlift.item

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.databinding.ActivityItemBinding
import com.cookandroid.wildlift.item.dialog.ItemSearchDialog
import com.cookandroid.wildlift.item.fragment.*
import com.cookandroid.wildlift.singleton.FirebaseSingleton
import com.google.android.material.tabs.TabLayoutMediator

class ItemActivity : BaseActivity<ActivityItemBinding>(R.layout.activity_item) {
    private val model by lazy { ViewModelProvider(this).get(ItemActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, R.string.search, 0, R.string.search)?.setIcon(R.drawable.ic_search)?.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.string.search -> {
                ItemSearchDialog(this).show()
                true
            }

            android.R.id.home -> {
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun init() {
        initActionBar()
        initViewPager()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
                PhysicsFragment(), MagicFragment(),
                DefenseFragment(), ShoesFragment()
            )
        }
    }
}