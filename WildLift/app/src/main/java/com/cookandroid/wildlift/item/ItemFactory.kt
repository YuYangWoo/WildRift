package com.cookandroid.wildlift.item

import java.util.*
import kotlin.collections.HashMap

object ItemFactory {
    fun createFromHashMap(map: HashMap<String, Any>): Item {
        val name = map["name"] as String
        val imageURL = map["imageURL"] as String
        val description = map["description"] as String
        val use = map["use"] as String
        val cost = map["cost"] as Long
        val type = map["type"] as String
        val level = map["level"] as Long

        val into = arrayListOf<String>().apply {
            val st = StringTokenizer(map["into"] as String, "/")
            while (st.hasMoreTokens()) {
                add(st.nextToken())
            }
        }

        val from = arrayListOf<String>().apply {
            val st = StringTokenizer(map["from"] as String, "/")
            while (st.hasMoreTokens()) {
                add(st.nextToken())
            }
        }

        return Item(name, imageURL, description, use, cost, from, into, type, level)
    }
}