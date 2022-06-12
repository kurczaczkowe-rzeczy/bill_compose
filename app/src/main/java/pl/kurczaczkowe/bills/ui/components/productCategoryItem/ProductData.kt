package pl.kurczaczkowe.bills.ui.components.productCategoryItem

data class ProductData(
    val id: Int = -1,
    val name: String,
    val amount: Double,
    val entity: Entity,
    val isBought: Boolean = false
)
