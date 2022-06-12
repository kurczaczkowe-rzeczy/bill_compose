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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.kurczaczkowe.bills.ui.components.prodactCategory.ProductCategory
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.ProductCategoryItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuyListScreen(
) {
    val viewModel = BuyListViewModel()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        viewModel.categories.value.forEach { category ->
            stickyHeader {
                ProductCategory(
                    modifier = Modifier.padding(bottom = 8.dp),
                    showMore = category.isVisible,
                    getRestToBuy = category.getRestInBuyList,
                    setShowMore = { viewModel.onCategoryClick(category.categoryId) },
                    categoryColor = Color.Red,
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
                        backgroundColor = if (index % 2 == 0) MaterialTheme.colors.background else Color.LightGray,
                        onClick = {viewModel.onClickProduct(category.categoryId, it)}
                    )
                }
            }
        }
    }

}