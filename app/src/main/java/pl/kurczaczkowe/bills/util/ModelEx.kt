package pl.kurczaczkowe.bills.util

import pl.gungnir.database.entity.CategoryEntity
import pl.kurczaczkowe.bills.data.model.Category

fun Category.toCategoryEntity() = CategoryEntity(
    nameCategory = this.name,
    colorCategory = this.color.value.toInt(),
    isPremadeCategory = false
)