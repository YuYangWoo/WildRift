package com.cookandroid.wildlift.Lotation

import android.util.Log
import com.google.firebase.database.*

object LotationFactory {
    private lateinit var dbLocation: DatabaseReference
    var lotationList = ArrayList<LotationItem>()
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()

    init {
                dbLocation = database.getReference("LotationChampion")
        dbLocation.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                lotationList.clear()
                for (snapshot in snapshot.children) { // 반복문으로 데이터 List를 추출해냄
                    val list =  snapshot.getValue(LotationItem::class.java)  // 만들어뒀던 객체에 데이터를 담는다.
                    Log.d("test", list.toString())
                    lotationList.add(list!!) // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
            }

            override fun onCancelled(error: DatabaseError) {
       Log.d("Error", "에러! ")
            }

        })
    }
}