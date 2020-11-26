package com.cookandroid.wildlift.champion.championInfo

data class ChampionInformation(
    var name: String,
    var attack: String,
    var spellPower: String,
    var hp: String,
    var mp: String,
    var armor: String,
    var magicResistance: String,
    var attackSpeed: String,
    var coolTime: String,
    var criticalChance: String,
    var criticalDamage: String,
    var rune: List<RuneName>,
    var skill: List<Skill>,
    var spell: List<SpellName>,
    var item: List<ItemName>

) {
    constructor() : this("", "", "", "", "", "", "" ,"", "", "", "", listOf(), listOf(), listOf(), listOf())

    data class Skill(
        var image: String,
        var name: String,
        var coolTime: String,
        var description: String
    ) {
        constructor() : this("", "", "", "")
    }

    data class SpellName(
        var name: String
    ) {
        constructor() : this("")
    }

    data class ItemName(
        var name: String
    ) {
        constructor() : this("")
    }

    data class RuneName(
        var name: String
    ) {
        constructor() : this("")
    }
}