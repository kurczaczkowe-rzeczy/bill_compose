package pl.kurczaczkowe.bills.util

import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.db.entity.CategoryEntity

fun Category.toCategoryEntity() = CategoryEntity(
    nameCategory = this.name,
    colorCategory = this.color.value.toInt(),
    isPremadeCategory = false
)