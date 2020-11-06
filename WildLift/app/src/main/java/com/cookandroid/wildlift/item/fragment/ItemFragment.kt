package com.cookandroid.wildlift.item.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseFragment
import com.cookandroid.wildlift.databinding.FragmentItemBinding
import com.cookandroid.wildlift.item.ItemAdapter
import com.cookandroid.wildlift.item.ItemTestDB

abstract class ItemFragment : BaseFragment<FragmentItemBinding>(R.layout.fragment_item) {
    abstract val tabTitle: Int
    private val model by lazy { ViewModelProvider(this, ItemFragmentViewModelFactory(this)).get(
        ItemFragmentViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        init()

        return view
    }

    private fun init() {
        initFinalItem()
        initMiddleItem()
        initBaseItem()
    }

    private fun initFinalItem() {
        with(binding.finalRecyclerView) {
            adapter = model.finalAdapter
            layoutManager = GridLayoutManager(context, 4)
        }
    }

    private fun initMiddleItem() {
        with(binding.middleRecyclerView) {
            adapter = model.middleAdapter
            layoutManager = GridLayoutManager(context, 4)
        }
    }

    private fun initBaseItem() {
        with(binding.baseRecyclerView) {
            adapter = model.baseAdapter
            layoutManager = GridLayoutManager(context, 4)
        }
    }

    class ItemFragmentViewModel(private val fragment: ItemFragment) : ViewModel() {
        val finalAdapter by lazy { ItemAdapter().apply {
            list = ItemTestDB.request(fragment.getString(fragment.tabTitle), 1)
        } }
        val middleAdapter by lazy { ItemAdapter().apply {
            list = ItemTestDB.request(fragment.getString(fragment.tabTitle), 2)
        } }
        val baseAdapter by lazy { ItemAdapter().apply {
            list = ItemTestDB.request(fragment.getString(fragment.tabTitle), 3)
        } }
    }

    class ItemFragmentViewModelFactory(private val fragment: ItemFragment) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ItemFragmentViewModel(fragment) as T
        }
    }
}