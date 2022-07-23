package pl.gungnir.fetaurecategories.util

import pl.gungnir.database.entity.CategoryEntity

fun pl.gungnir.fetaurecategories.data.Category.toCategoryEntity() = CategoryEntity(
    nameCategory = this.name,
    colorCategory = this.color.value.toInt(),
    isPremadeCategory = false
)