package com.cookandroid.wildlift.singleton

import android.util.Log
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.item.ItemFactory
import com.cookandroid.wildlift.rune.Rune
import com.cookandroid.wildlift.rune.RuneFactory
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object FirebaseSingleton {
    var itemList = ArrayList<Item>()
    var runeList = ArrayList<Rune>()

    fun init() {
        FirebaseDatabase.getInstance()
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

        FirebaseDatabase.getInstance()
            .getReference("runeList")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val map = snapshot.value as HashMap<String, HashMap<String, Any>>
                    runeList = arrayListOf<Rune>().apply {
                        map.values.forEach {
                            add(RuneFactory.createFromHashMap(it))
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }
}