package com.cookandroid.wildlift.item

data class Item(
    var name: String,
    var imageURL: String,
    var description: String,
    var use: String,
    var cost: Long,
    var from: List<String>,
    var into: List<String>,
    var type: String,
    var level: Long,
) {
    constructor() : this("", "", "", "", 0L, listOf(), listOf(), "", 0L)
}