package com.cookandroid.wildlift.item

object ItemTestDB {
    fun request(type: String, depth: Int): List<Item> {
        return if (type == "Physics") {
            when (depth) {
                1 -> {
                    listOf(Item(3072, "피바라기", "<stats>공격력 +80</stats><br><br><unique>고유 지속 효과:</unique> 생명력 흡수 +20%<br><unique>고유 지속 효과:</unique> 기본 공격을 통한 회복이 최대 체력 이상으로 가능합니다. 초과된 생명력은 보호막으로 전환되어 챔피언 레벨에 따라 50-350의 피해량을 막아줍니다.<br><br>이 보호막은 25초간 피해를 입히거나 받지 않으면 서서히 줄어듭니다.", 3500, 950, 2450, listOf(1038, 1036, 1053), listOf()))
                }
                2 -> {
                    listOf(Item(3072, "피바라기", "<stats>공격력 +80</stats><br><br><unique>고유 지속 효과:</unique> 생명력 흡수 +20%<br><unique>고유 지속 효과:</unique> 기본 공격을 통한 회복이 최대 체력 이상으로 가능합니다. 초과된 생명력은 보호막으로 전환되어 챔피언 레벨에 따라 50-350의 피해량을 막아줍니다.<br><br>이 보호막은 25초간 피해를 입히거나 받지 않으면 서서히 줄어듭니다.", 3500, 950, 2450, listOf(1038, 1036, 1053), listOf()))
                }
                else -> {
                    listOf(Item(3072, "피바라기", "<stats>공격력 +80</stats><br><br><unique>고유 지속 효과:</unique> 생명력 흡수 +20%<br><unique>고유 지속 효과:</unique> 기본 공격을 통한 회복이 최대 체력 이상으로 가능합니다. 초과된 생명력은 보호막으로 전환되어 챔피언 레벨에 따라 50-350의 피해량을 막아줍니다.<br><br>이 보호막은 25초간 피해를 입히거나 받지 않으면 서서히 줄어듭니다.", 3500, 950, 2450, listOf(1038, 1036, 1053), listOf()))
                }
            }
        } else {
            listOf(Item(3089, "라바돈의 죽음모자", "<stats>공격력 +80</stats><br><br><unique>고유 지속 효과:</unique> 생명력 흡수 +20%<br><unique>고유 지속 효과:</unique> 기본 공격을 통한 회복이 최대 체력 이상으로 가능합니다. 초과된 생명력은 보호막으로 전환되어 챔피언 레벨에 따라 50-350의 피해량을 막아줍니다.<br><br>이 보호막은 25초간 피해를 입히거나 받지 않으면 서서히 줄어듭니다.", 3500, 950, 2450, listOf(1038, 1036, 1053), listOf()))
        }
    }
}