package com.cookandroid.wildlift.item

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.databinding.ActivityItemBinding

class ItemActivity : BaseActivity<ActivityItemBinding>(R.layout.activity_item) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initActionBar()
        initRecyclerView()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            adapter = ItemAdapter(this@ItemActivity)
            layoutManager = GridLayoutManager(this@ItemActivity, 4)
        }
    }
}