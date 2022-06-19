package pl.kurczaczkowe.bills.ui.screen.categoryList

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kurczaczkowe.bills.ui.components.errorScreen.ErrorScreen
import pl.kurczaczkowe.bills.ui.components.loading.Loading
import pl.kurczaczkowe.bills.ui.components.prodactCategory.ProductCategory
import pl.kurczaczkowe.bills.ui.components.prodactCategory.ProductCategoryType
import pl.kurczaczkowe.bills.R
import pl.kurczaczkowe.bills.ui.theme.BillsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryListScreen(
    modifier: Modifier = Modifier,
    listState: CategoryListState = CategoryListState.Loading
) {

    when (listState) {
        CategoryListState.Empty -> Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
                .padding(16.dp)
        ) {
            Text(
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
                text = stringResource(id = R.string.empty_category_list)
            )
        }
        CategoryListState.Failure -> ErrorScreen()
        CategoryListState.Loading -> Loading()
        is CategoryListState.Success -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items = listState.data, key = { category -> category.id }) { category ->
                    ProductCategory(
                        modifier = Modifier.animateItemPlacement(),
                        type = ProductCategoryType.CATEGORY_ITEM,
                        categoryColor = category.color
                    ) {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.h4,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun CategoryListDarkPreview() {
    BillsTheme { CategoryListScreen(listState = CategoryListState.Empty) }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun CategoryListPreview() {
    BillsTheme { CategoryListScreen(listState = CategoryListState.Empty) }
}