package com.cookandroid.wildRift.champion.championInfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.champion.championInfo.Board.ChampionBoard
import com.cookandroid.wildRift.singleton.FirebaseSingleton
import com.cookandroid.wildRift.spell.SpellFactory
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_champion_info.*

class ChampionInfo : AppCompatActivity() {
    private lateinit var championInformation: ChampionInformation
    private var recyclerItemAdapter = ItemAdapter()
    private var recyclerRuneAdapter = ItemAdapter()
    private var recyclerSpellAdapter = ItemAdapter()
    private lateinit var layoutManagerItem: RecyclerView.LayoutManager
    private lateinit var layoutManagerRune: RecyclerView.LayoutManager
    private lateinit var layoutManagerSpell: RecyclerView.LayoutManager
    private var itemUrl = ArrayList<ItemAdapter.ItemType>()
    private var runeUrl = ArrayList<ItemAdapter.ItemType>()
    private var spellUrl = ArrayList<ItemAdapter.ItemType>()
    private lateinit var champImg :String
    private lateinit var champName :String
    private lateinit var champPosition :String
    private lateinit var champEngName :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champion_info)

        // ActionBar Title 변경
        title = resources.getString(R.string.champion_info_title)

         champImg = intent.getStringExtra("championImage").toString()
         champName = intent.getStringExtra("championName").toString()
         champPosition = intent.getStringExtra("championPosition").toString()
         champEngName = intent.getStringExtra("championEngName").toString()

        championInformation = run {
            for (information in FirebaseSingleton.championInformationList) {
                if (information.name == champName) {
                    return@run information
                }
            }

            return@run ChampionInformation()
        }

        // 추천 아이템 리스트
        recyclerItem.setHasFixedSize(true)
        layoutManagerItem = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerItem.layoutManager = layoutManagerItem
        for (i in FirebaseSingleton.itemList) {
            for (j in championInformation.item) {
                if (i.name == j.name) {
                    itemUrl.add(ItemAdapter.ItemType(ItemAdapter.ItemType.ITEM, i.imageURL))
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
                    runeUrl.add(ItemAdapter.ItemType(ItemAdapter.ItemType.RUNE, i.image))
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
                    spellUrl.add(ItemAdapter.ItemType(ItemAdapter.ItemType.SPELL, i.image!!))
                }
            }
        }
        recyclerSpellAdapter = ItemAdapter(spellUrl)
        recyclerSpell.adapter = recyclerSpellAdapter

        // 챔피언 이미지
        Glide.with(this) // 띄어줄 뷰를 명시
            .load(champImg) // 이미지 주소
            .into(imgChampImage) // list_log의 imageView에 띄우기
        txtChampName.text = champName
        txtChampPosition.text = champPosition

        btnInit()
        // 배너광고
        var mAdView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
    fun btnInit() {
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

        // 능력치/스킬 버튼
        btnAbility.setOnClickListener {
            var intent = Intent(this, ChampionAbility::class.java)
            intent.putExtra("championInformation", championInformation)
            startActivity(intent)
        }

        // 게시판 버튼
        btnBoard.setOnClickListener {
            var intent = Intent(this, ChampionBoard::class.java)
            intent.putExtra("championName", champName)
            startActivity(intent)
        }
    }
}