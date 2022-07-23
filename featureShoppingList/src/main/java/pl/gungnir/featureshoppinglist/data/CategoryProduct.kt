package pl.gungnir.featureshoppinglist.data

import androidx.compose.ui.graphics.Color
import pl.gungnir.featureshoppinglist.components.productCategoryItem.ProductData

data class CategoryProduct(
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