package pl.gungnir.featureshoppinglist.useCase

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.gungnir.base.*
import pl.gungnir.database.domain.repository.BuyListRepository
import pl.gungnir.featureshoppinglist.components.productCategoryItem.ProductData
import pl.gungnir.featureshoppinglist.data.CategoryProduct

class GetBuyListUseCase(
    private val buyListRepository: BuyListRepository
) : BaseUseCase<Either<Failure, Flow<List<CategoryProduct>>>, Int>() {

    override suspend fun run(params: Int): Either<Failure, Flow<List<CategoryProduct>>> {
        return buyListRepository.getBuyList(params).flatMap {
            it.map {
                it.map{ category ->
                    CategoryProduct(
                        categoryId = category.idCategory ?: -1,
                        name = category.nameCategory,
                        color = Color(category.colorCategory),
                        isVisible = false,
                        itemList = listOf(
                            ProductData(
                                id = 0,
                                name = "Name",
                                amount = 0.0,
                                entity = Entity.KILOGRAM,
                                isBought = false
                            ),
                            ProductData(
                                id = 1,
                                name = "Name",
                                amount = 0.0,
                                entity = Entity.KILOGRAM,
                                isBought = false
                            )
                        )
                    )
                }
            }.right()
        }
    }
}