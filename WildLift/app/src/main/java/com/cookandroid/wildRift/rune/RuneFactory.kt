package com.cookandroid.wildRift.rune

import kotlin.collections.HashMap

object RuneFactory {
    fun createFromHashMap(map: HashMap<String, Any>): Rune {
        val name = map["name"] as String
        val imageURL = map["image"] as String
        val subtitle = map["subtitle"] as String
        val topic = map["topic"] as String
        val type = map["type"] as String

        return Rune(name, imageURL, subtitle, topic, type)
    }
}