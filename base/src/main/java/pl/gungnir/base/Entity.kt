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