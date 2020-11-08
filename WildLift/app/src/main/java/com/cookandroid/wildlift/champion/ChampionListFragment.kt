package com.cookandroid.wildlift.champion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.wildlift.R
import com.google.firebase.database.*

class ChampionListFragment(val tabTitle: Int) : Fragment() {

    private lateinit var championAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var database: FirebaseDatabase
    private lateinit var dbChampion: DatabaseReference

    // 챔피언 리스트
    private var championList: ArrayList<ChampionItem> = ArrayList()
    private var list = ArrayList<ChampionItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_champion_list, container, false)

        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // LinearLayoutManager 객체 생성 후 layoutManager에 대입 및 recyclerView 고정크기 On
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // 파이어베이스 데이터베이스 연동
        database = FirebaseDatabase.getInstance()

        // DB 테이블 연결
        dbChampion = database.getReference("championList")

        // logList에 DB데이터 연결
        dbChampion.addListenerForSingleValueEvent(object : ValueEventListener {

            // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                championList.clear()
                list.clear()
                for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                    val champion =
                        snapshot.getValue(ChampionItem::class.java) // 만들어뒀던 객체에 데이터를 담는다.
                    championList.add(champion!!) // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }

                championAdapter = when (tabTitle) {
                    R.string.champion_list_All -> ChampionAdapter(championList, context!!)
                    else -> {
                        for (item in championList) {
                            var countList = item.position!!.split(",")
                            for (pos in countList) {
                                if (pos == getString(tabTitle)) {
                                    list.add(item)
                                }
                            }
                        }
                        ChampionAdapter(list, context!!)
                    }
                }
                recyclerView.adapter = championAdapter
                championAdapter.notifyDataSetChanged() // 리스트 저장 및 새로고침해야 반영이 됨
            }

            // 디비를 가져오던중 에러 발생 시 에러문 출력
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error", databaseError.toException().toString())
            }
        })

        return view
    }
}