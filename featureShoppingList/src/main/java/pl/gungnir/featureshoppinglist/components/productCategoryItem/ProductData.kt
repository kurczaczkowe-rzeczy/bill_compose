package pl.gungnir.featureshoppinglist.components.productCategoryItem

import pl.gungnir.base.Entity

data class ProductData(
    val id: String,
    val name: String,
    val amount: Long,
    val entity: Entity,
    val isBought: Boolean = false
)
