package com.cookandroid.wildlift.singleton

import android.util.Log
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.item.ItemFactory
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object FirebaseSingleton {
    val itemList = ArrayList<Item>()

    fun init() {
        FirebaseDatabase.getInstance()
            .getReference("ItemList")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val map = snapshot.value as HashMap<String, HashMap<String, Any>>
                    for (value in map.values) {
                        itemList.add(ItemFactory.createFromHashMap(value))
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }
}