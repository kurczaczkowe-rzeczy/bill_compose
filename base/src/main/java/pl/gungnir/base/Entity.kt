package pl.gungnir.base

enum class Entity {
    METER,
    CENTIMETER,
    LITER,
    MILLILITER,
    KILOGRAM,
    GRAM,
    QUANTITY,
    PACK
}

fun Entity.getUnitShort(): String {
    return when (this) {
        Entity.METER -> "m"
        Entity.CENTIMETER -> "cm"
        Entity.LITER -> "l"
        Entity.MILLILITER -> "ml"
        Entity.KILOGRAM -> "kg"
        Entity.GRAM -> "g"
        Entity.QUANTITY -> "szt."
        Entity.PACK -> "kpl."
    }
}

fun String.getEntityByShort(): Entity {
    return when (this) {
        "m" -> Entity.METER
        "cm" -> Entity.CENTIMETER
        "l" -> Entity.LITER
        "ml" -> Entity.MILLILITER
        "kg" -> Entity.KILOGRAM
        "g" -> Entity.GRAM
        "kpl." -> Entity.PACK
        else -> Entity.QUANTITY
    }
}