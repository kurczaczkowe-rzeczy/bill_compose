package pl.gungnir.database.data

class ShoppingItem(
    val id: String,
    val productCategory: String,
    val name: String,
    val amount: Long,
    val inCart: Boolean,
    val unit: String
)