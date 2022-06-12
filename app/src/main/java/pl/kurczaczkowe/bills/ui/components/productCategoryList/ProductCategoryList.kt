package pl.kurczaczkowe.bills.ui.components.productCategoryList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.Entity
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.ProductCategoryItem
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.ProductData

//@Composable
//fun ProductCategoryList(
//    modifier: Modifier = Modifier,
//    list: List<ProductData>,
//    product: @Composable (product: ProductData, backgroundColor: Color) -> Unit
//) {
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxWidth()
//            .then(modifier)
//    ) {
//        itemsIndexed(list) { index, product ->
//            product(
//                product,
//                if (index % 2 == 0) MaterialTheme.colors.background else Color.LightGray
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun ProductCategoryListPreview() {
//    ProductCategoryList(
//        list = listOf(
//            ProductData(name = "Apple", amount = 2.0, entity = Entity.KILOGRAM),
//            ProductData(name = "Banana", amount = 6.0, entity = Entity.QUANTITY),
//            ProductData(name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
//        ),
//        product = { product, background ->
//            ProductCategoryItem(
//                product = product,
//                backgroundColor = background,
//            )
//        }
//    )
//}