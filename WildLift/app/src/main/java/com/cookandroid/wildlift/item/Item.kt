package com.cookandroid.wildlift.item

data class Item(
    var id: Int,
    var name: String,
    var description: String,
    var totalCost: Int,
    var combinationCost: Int,
    var sellCost: Int,
    var from: List<Item>,
    var into: List<Item>
) {
    fun getImageURL(): String {
        return "http://ddragon.leagueoflegends.com/cdn/10.22.1/img/item/$id.png"
    }
}