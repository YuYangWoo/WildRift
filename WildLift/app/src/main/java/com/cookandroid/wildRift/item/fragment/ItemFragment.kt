package com.cookandroid.wildRift.item.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.base.BaseFragment
import com.cookandroid.wildRift.databinding.FragmentItemBinding
import com.cookandroid.wildRift.item.Item
import com.cookandroid.wildRift.item.ItemAdapter
import com.cookandroid.wildRift.singleton.FirebaseSingleton

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
            val list = ArrayList<Item>()
            for (item in FirebaseSingleton.itemList) {
                if (item.type == fragment.getString(fragment.tabTitle) && item.level == 3L) {
                    list.add(item)
                }
            }

            this.list = list
        } }
        val middleAdapter by lazy { ItemAdapter().apply {
            val list = ArrayList<Item>()
            for (item in FirebaseSingleton.itemList) {
                if (item.type == fragment.getString(fragment.tabTitle) && item.level == 2L) {
                    list.add(item)
                }
            }

            this.list = list
        } }
        val baseAdapter by lazy { ItemAdapter().apply {
            val list = ArrayList<Item>()
            for (item in FirebaseSingleton.itemList) {
                if (item.type == fragment.getString(fragment.tabTitle) && item.level == 1L) {
                    list.add(item)
                }
            }

            this.list = list
        } }
    }

    class ItemFragmentViewModelFactory(private val fragment: ItemFragment) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ItemFragmentViewModel(fragment) as T
        }
    }
}