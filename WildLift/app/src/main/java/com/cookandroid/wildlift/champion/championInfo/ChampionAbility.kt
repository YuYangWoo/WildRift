package com.cookandroid.wildlift.champion.championInfo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseActivity
import com.cookandroid.wildlift.base.BaseHolder
import com.cookandroid.wildlift.champion.ChampionFactory
import com.cookandroid.wildlift.databinding.ActivityChampionAbilityBinding
import com.cookandroid.wildlift.databinding.HolderSkillBinding
import kotlin.properties.Delegates

class ChampionAbility : BaseActivity<ActivityChampionAbilityBinding>(R.layout.activity_champion_ability) {
    private val information by lazy { intent.getSerializableExtra("championInformation") as? ChampionInformation ?: ChampionInformation() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initActionBar()
        initChampionInformation()
        initImage()
        initRecyclerView()
    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initChampionInformation() {
        binding.information = information
    }

    private fun initImage() {
        ChampionFactory.championList.forEach {
            if (it.name == information.name) {
                binding.image = it.image
                Log.d("PASS", information.toString())
            }
        }
    }

    private fun initRecyclerView() {
        Log.d("PASS", "Hi")

        with(binding.recyclerView) {
            layoutManager = object : LinearLayoutManager(this@ChampionAbility) {

            }

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