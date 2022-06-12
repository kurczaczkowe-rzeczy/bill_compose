package pl.kurczaczkowe.bills.data.model

import androidx.compose.ui.graphics.Color
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.ProductData

data class Category(
    val categoryId: Int,
    val name: String,
    val color: Color,
    val isVisible: Boolean = false,
    val itemList: List<ProductData>
) {

    val getRestInBuyList = itemList.count {
        !it.isBought
    }
}