package com.cookandroid.wildlift.rune

data class Rune(
    var name: String,
    var image: String,
    var subtitle: String,
    var topic: String,
    var type: String
) {
    constructor() : this("", "", "", "", "")
}