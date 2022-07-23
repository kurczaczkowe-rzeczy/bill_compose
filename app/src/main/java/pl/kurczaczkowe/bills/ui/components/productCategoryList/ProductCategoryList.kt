package pl.kurczaczkowe.bills.ui.components.productCategoryList

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