package pl.kurczaczkowe.bills.ui.screen.buyList

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.ui.components.prodactCategory.ProductCategory
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.ProductCategoryItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuyListScreen(
    categories: MutableState<List<Category>> = mutableStateOf(emptyList()),
    onClickProduct: (categoryId: Int, productId: Int) -> Unit = {_, _ -> },
    onCategoryClick: (categoryId: Int) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        categories.value.forEach { category ->
            stickyHeader {
                ProductCategory(
                    modifier = Modifier.padding(bottom = 8.dp),
                    showMore = category.isVisible,
                    getRestToBuy = category.getRestInBuyList,
                    setShowMore = { onCategoryClick(category.categoryId) },
                    categoryColor = category.color,
                    category = {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.h4,
                            color = Color.White
                        )
                    }
                )
            }

            itemsIndexed(category.itemList) { index, product ->
                AnimatedVisibility(
                    visible = category.isVisible,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    ProductCategoryItem(
                        product = product,
                        backgroundColor = if (index % 2 == 0) MaterialTheme.colors.background else MaterialTheme.colors.surface,
                        onClick = { onClickProduct(category.categoryId, it) }
                    )
                }
            }
        }
    }

}