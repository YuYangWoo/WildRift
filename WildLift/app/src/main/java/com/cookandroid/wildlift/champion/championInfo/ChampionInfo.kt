package com.cookandroid.wildlift.champion.championInfo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.singleton.FirebaseSingleton
import com.cookandroid.wildlift.spell.SpellFactory
import kotlinx.android.synthetic.main.activity_champion_info.*

class ChampionInfo : AppCompatActivity() {
    private lateinit var championInformation: ChampionInformation
    private var recyclerItemAdapter = com.cookandroid.wildlift.champion.championInfo.ItemAdapter()
    private var recyclerRuneAdapter = com.cookandroid.wildlift.champion.championInfo.ItemAdapter()
    private var recyclerSpellAdapter = com.cookandroid.wildlift.champion.championInfo.ItemAdapter()
    private lateinit var layoutManagerItem: RecyclerView.LayoutManager
    private lateinit var layoutManagerRune: RecyclerView.LayoutManager
    private lateinit var layoutManagerSpell: RecyclerView.LayoutManager
    private var itemUrl = ArrayList<String>()
    private var runeUrl = ArrayList<String>()
    private var spellUrl = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_info)

        // ActionBar Title 변경
        title = resources.getString(R.string.champion_info_title)

        var champImg = intent.getStringExtra("championImage")
        var champName = intent.getStringExtra("championName")
        var champPosition = intent.getStringExtra("championPosition")
        var champEngName = intent.getStringExtra("championEngName")
        championInformation = run {
            for (information in FirebaseSingleton.championInformationList) {
                if (information.name == champName) {
                    return@run information
                }
            }

            return@run ChampionInformation()
        }
        Log.d("PASS", championInformation.skill[1].toString())

        // 추천 아이템 리스트
        recyclerItem.setHasFixedSize(true)
        layoutManagerItem = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerItem.layoutManager = layoutManagerItem
        for (i in FirebaseSingleton.itemList) {
            for (j in championInformation.item) {
                if (i.name == j.name) {
                    itemUrl.add(i.imageURL)
                }
            }
        }
        recyclerItemAdapter = ItemAdapter(itemUrl)
        recyclerItem.adapter = recyclerItemAdapter

        // 추천 룬 리스트
        recyclerRune.setHasFixedSize(true)
        layoutManagerRune = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerRune.layoutManager = layoutManagerRune
        for (i in FirebaseSingleton.runeList) {
            for (j in championInformation.rune) {
                if (i.name == j.name) {
                   runeUrl.add(i.image)
                }
            }
        }
        recyclerRuneAdapter = ItemAdapter(runeUrl)
        recyclerRune.adapter = recyclerRuneAdapter

        // 추천 스펠 리스트
        recyclerSpell.setHasFixedSize(true)
        layoutManagerSpell = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerSpell.layoutManager = layoutManagerSpell
        for (i in SpellFactory.spellList) {
            for (j in championInformation.spell) {
                if (i.name == j.name) {
                    spellUrl.add(i.image!!)
                }
            }
        }
        recyclerSpellAdapter = ItemAdapter(spellUrl)
        recyclerSpell.adapter = recyclerSpellAdapter

        Glide.with(this) // 띄어줄 뷰를 명시
            .load(champImg) // 이미지 주소
            .into(imgChampImage) // list_log의 imageView에 띄우기
        txtChampName.text = champName
        txtChampPosition.text = champPosition

        // 스킬/스킨 버튼
        btnSkillSkin.setOnClickListener {
            var intent = Intent(this, ChampionSkillSkin::class.java)
            intent.putExtra("championEngName", champEngName)
            startActivity(intent)
        }
        // 챔피언 유니버스 버튼
        btnUniverse.setOnClickListener {
            var intent = Intent(this, ChampionUniverse::class.java)
            intent.putExtra("championEngName", champEngName)
            startActivity(intent)
        }
    }
}