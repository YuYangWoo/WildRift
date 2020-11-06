package com.cookandroid.wildlift.item

import org.json.JSONObject

object ItemFactory {
    fun createFromJsonObject(id: Int, json: JSONObject): Item {
        val name = json.getString("name")
        val description = json.getString("description")

        val costJson = json.getJSONObject("gold")
        val totalCost = costJson.getInt("total")
        val combinationCost = costJson.getInt("base")
        val sellCost = costJson.getInt("sell")

        val from = if (json.has("from")) {
            val fromJson = json.getJSONArray("from")
            ArrayList<Int>().apply {
                for (i in 0 until fromJson.length()) {
                    add(fromJson.getInt(i))
                }
            }
        } else {
            listOf()
        }

        val into = if (json.has("into")) {
            val intoJson = json.getJSONArray("into")
            ArrayList<Int>().apply {
                for (i in 0 until intoJson.length()) {
                    add(intoJson.getInt(i))
                }
            }
        } else {
            listOf()
        }

        return Item(id, name, description, totalCost, combinationCost, sellCost, from, into)
    }
}