package com.cookandroid.wildRift.spell

import android.util.Log
import com.google.firebase.database.*

object SpellFactory {
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private lateinit var dbSpell: DatabaseReference
    var spellList = ArrayList<SpellItem>()
    init {
        // DB 테이블 연결
        dbSpell = database.getReference("SpellList")

        // logList에 DB데이터 연결
        dbSpell.addListenerForSingleValueEvent(object : ValueEventListener {

            // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                spellList.clear()
                for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                    val spell =
                        snapshot.getValue(SpellItem::class.java) // 만들어뒀던 객체에 데이터를 담는다.
                    spellList.add(spell!!) // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
            }

            // 디비를 가져오던중 에러 발생 시 에러문 출력
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error", databaseError.toException().toString())
            }
        })
}
}