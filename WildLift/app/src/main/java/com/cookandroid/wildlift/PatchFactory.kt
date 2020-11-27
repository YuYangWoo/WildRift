package com.cookandroid.wildlift

import android.util.Log
import com.google.firebase.database.*

object PatchFactory {
    var patchList = ArrayList<PatchItem>()
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var dbPatch: DatabaseReference
    init {
        // DB 테이블 연결
        dbPatch = database.getReference("patchList")

        // logList에 DB데이터 연결
        dbPatch.addListenerForSingleValueEvent(object : ValueEventListener {

            // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
            override fun onDataChange(dataSnapshot: DataSnapshot) {
               patchList.clear()
                for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                    val list =
                        snapshot.getValue(PatchItem::class.java) // 만들어뒀던 객체에 데이터를 담는다.
                    patchList.add(list!!) // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
            }

            // 디비를 가져오던중 에러 발생 시 에러문 출력
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error", databaseError.toException().toString())
            }
        })
    }
}