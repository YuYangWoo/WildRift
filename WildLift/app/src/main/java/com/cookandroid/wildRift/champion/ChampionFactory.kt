package com.cookandroid.wildRift.champion

import android.util.Log
import com.google.firebase.database.*

object ChampionFactory {
    var championList: ArrayList<ChampionItem> = ArrayList()
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var dbChampion: DatabaseReference
    init{
        // 파이어베이스 데이터베이스 연동

        // DB 테이블 연결
        dbChampion = database.getReference("championList")

        // logList에 DB데이터 연결
        dbChampion.addListenerForSingleValueEvent(object : ValueEventListener {

            // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                championList.clear()
                for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                    val champion =
                        snapshot.getValue(ChampionItem::class.java) // 만들어뒀던 객체에 데이터를 담는다.
                    championList.add(champion!!) // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
            }

            // 디비를 가져오던중 에러 발생 시 에러문 출력
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error", databaseError.toException().toString())
            }
        })
    }
}