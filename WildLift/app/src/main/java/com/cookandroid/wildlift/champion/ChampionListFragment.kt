package com.cookandroid.wildlift.champion

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.R
import com.google.firebase.database.*

class ChampionListFragment(val tabTitle: Int) : Fragment() {

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var recyclerViewAdapter = ChampionAdapter()
    private lateinit var database: FirebaseDatabase
    private lateinit var dbChampion: DatabaseReference
    private var search = ""
    // 챔피언 리스트
    private var championList = ChampionFactory.championList
    private var list = ArrayList<ChampionItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_champion_list, container, false)

        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        var searchView = view.findViewById<EditText>(R.id.search_bar)
        // LinearLayoutManager 객체 생성 후 layoutManager에 대입 및 recyclerView 고정크기 On
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        list.clear()
        // 파이어베이스 데이터베이스 연동
        database = FirebaseDatabase.getInstance()

        // DB 테이블 연결
        dbChampion = database.getReference("championList")

        recyclerViewAdapter = when (tabTitle) {
            R.string.champion_list_All -> {
                ChampionAdapter(championList)
            }
            else -> {
                for (item in championList) {
                    var countList = item.position!!.split(",")
                    for (pos in countList) {
                        if (pos == getString(tabTitle)) {
                            list.add(item)
                        }
                    }
                }
                ChampionAdapter(list)
            }
        }
        recyclerView.adapter = recyclerViewAdapter

        // searchView에 입력에 따른 변화
        searchView.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                recyclerViewAdapter.filter.filter(s)
                search = s.toString()
            }

            override fun afterTextChanged(arg0: Editable) {
                // 입력이 끝났을 때 조치
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // 입력하기 전에 조치
            }
        })
        return view
    }
}