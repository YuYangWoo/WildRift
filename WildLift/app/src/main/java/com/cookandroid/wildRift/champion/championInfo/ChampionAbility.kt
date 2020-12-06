package com.cookandroid.wildRift.champion.championInfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.RecyclerViewDecoration
import com.cookandroid.wildRift.base.BaseActivity
import com.cookandroid.wildRift.base.BaseHolder
import com.cookandroid.wildRift.champion.ChampionFactory
import com.cookandroid.wildRift.databinding.ActivityChampionAbilityBinding
import com.cookandroid.wildRift.databinding.HolderSkillBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlin.properties.Delegates

class ChampionAbility : BaseActivity<ActivityChampionAbilityBinding>(R.layout.activity_champion_ability) {
    private val information by lazy { intent.getSerializableExtra("championInformation") as? ChampionInformation ?: ChampionInformation() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        // 배너광고
        val mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
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
        initChampionInformation()
        initImage()
        initRecyclerView()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "챔피언 정보"
    }

    private fun initChampionInformation() {
        binding.information = information
    }

    private fun initImage() {
        ChampionFactory.championList.forEach {
            if (it.name == information.name) {
                binding.image = it.image
            }
        }
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@ChampionAbility)
            addItemDecoration(RecyclerViewDecoration())
            adapter = SkillAdapter().apply {
                list = information.skill
            }

            Log.d("PASS", information.skill.size.toString())
        }
    }

    private class SkillAdapter : RecyclerView.Adapter<SkillHolder>() {
        var list by Delegates.observable(listOf<ChampionInformation.Skill>()) { _, _, _ ->
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillHolder {
            return SkillHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false))
        }

        override fun onBindViewHolder(holder: SkillHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun getItemViewType(position: Int): Int {
            return R.layout.holder_skill
        }
    }

    private class SkillHolder(binding: HolderSkillBinding) : BaseHolder<HolderSkillBinding, ChampionInformation.Skill>(binding) {
        override fun bind(item: ChampionInformation.Skill) {
            super.bind(item)
            binding.skill = item
        }
    }
}