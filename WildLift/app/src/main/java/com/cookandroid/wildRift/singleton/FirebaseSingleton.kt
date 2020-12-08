package com.cookandroid.wildRift.singleton

import android.util.Log
import com.cookandroid.wildRift.champion.championInfo.ChampionInformation
import com.cookandroid.wildRift.item.Item
import com.cookandroid.wildRift.item.ItemFactory
import com.cookandroid.wildRift.rune.Rune
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

object FirebaseSingleton {
    private var database = FirebaseDatabase.getInstance()
    var itemList = ArrayList<Item>()
    var runeList = ArrayList<Rune>()
    var championInformationList = ArrayList<ChampionInformation>()
    fun init() {
        database
            .getReference("ItemList")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val map = snapshot.value as HashMap<String, HashMap<String, Any>>
                    itemList = arrayListOf<Item>().apply {
                        map.values.forEach {
                            add(ItemFactory.createFromHashMap(it))
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        

        database
            .getReference("runeList")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<Rune>()
                    for (data in snapshot.children) {
                        data.getValue(Rune::class.java)?.let { list.add(it) }
                    }

                    runeList = list
                }

                // 디비를 가져오던중 에러 발생 시 에러문 출력
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e("Error", databaseError.toException().toString())
                }
            })

        FirebaseDatabase.getInstance()
            .getReference("championInfo")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<ChampionInformation>()
                    for (data in snapshot.children) {
                        data.getValue(ChampionInformation::class.java)?.let { list.add(it) }
                    }
                    championInformationList = list
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }
}