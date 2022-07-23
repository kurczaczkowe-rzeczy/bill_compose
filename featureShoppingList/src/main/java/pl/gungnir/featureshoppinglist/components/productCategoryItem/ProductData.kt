package pl.gungnir.featureshoppinglist.components.productCategoryItem

import pl.gungnir.base.Entity

data class ProductData(
    val id: Int = -1,
    val name: String,
    val amount: Double,
    val entity: Entity,
    val isBought: Boolean = false
)
