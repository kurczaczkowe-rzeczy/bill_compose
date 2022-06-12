package pl.kurczaczkowe.bills.data.repository

import androidx.compose.ui.graphics.Color
import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.domain.Either
import pl.kurczaczkowe.bills.domain.repository.BuyListRepository
import pl.kurczaczkowe.bills.domain.right
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.Entity
import pl.kurczaczkowe.bills.ui.components.productCategoryItem.ProductData
import pl.kurczaczkowe.bills.ui.screen.base.Failure

class BuyListRepositoryImpl: BuyListRepository {

    override fun getBuyList(id: Int): Either<Failure, List<Category>> {
        return listOf(
            Category(
                categoryId = 1,
                name = "Category 1",
                color = Color.Red,
                itemList = listOf(
                    ProductData(id = 1, name = "Apple", amount = 2.0, entity = Entity.KILOGRAM),
                    ProductData(id = 2, name = "Banana", amount = 6.0, entity = Entity.QUANTITY),
                    ProductData(id = 3, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM)
                )
            ),
            Category(
                categoryId = 2,
                name = "Category 2",
                color = Color.Green,
                itemList = listOf(
                    ProductData(id = 4, name = "Apple", amount = 2.0, entity = Entity.KILOGRAM),
                    ProductData(id = 5, name = "Banana", amount = 6.0, entity = Entity.QUANTITY),
                    ProductData(id = 6, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 7, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 8, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 9, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 10, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 11, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 12, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 13, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 14, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 15, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 16, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 17, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 18, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 19, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 20, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 21, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 22, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 23, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 24, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 25, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 26, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 27, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 28, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 29, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                    ProductData(id = 30, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM),
                )
            ),
            Category(
                categoryId = 3,
                name = "Category 3",
                color = Color.Blue,
                itemList = listOf(
                    ProductData(id = 31, name = "Apple", amount = 2.0, entity = Entity.KILOGRAM),
                    ProductData(id = 32, name = "Banana", amount = 6.0, entity = Entity.QUANTITY),
                    ProductData(id = 33, name = "Carrot", amount = 1.0, entity = Entity.KILOGRAM)
                )
            ),
        ).right()
    }
}