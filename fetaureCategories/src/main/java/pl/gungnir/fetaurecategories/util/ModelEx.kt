package pl.gungnir.fetaurecategories.util

import androidx.compose.ui.graphics.toArgb
import pl.gungnir.database.entity.CategoryEntity

fun pl.gungnir.fetaurecategories.data.Category.toCategoryEntity() = CategoryEntity(
    nameCategory = this.name,
    colorCategory = this.color.toArgb(),
    isPremadeCategory = false
)