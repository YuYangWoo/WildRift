package com.cookandroid.wildRift.rune

data class Rune(
    var name: String,
    var image: String,
    var subtitle: String,
    var topic: String,
    var type: String
) {
    constructor() : this("", "", "", "", "")
}