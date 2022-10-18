package pl.gungnir.featureshoppinglist.useCase

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.gungnir.base.BaseUseCase
import pl.gungnir.base.getEntityByShort
import pl.gungnir.database.domain.repository.BuyListRepository
import pl.gungnir.featureshoppinglist.components.productCategoryItem.ProductData
import pl.gungnir.featureshoppinglist.data.CategoryProduct

class GetBuyListUseCase(
    private val buyListRepository: BuyListRepository
) : BaseUseCase<Flow<List<CategoryProduct>>, String>() {

    override suspend fun run(params: String): Flow<List<CategoryProduct>> {
        return buyListRepository.getBuyList(params).map {
            it.groupBy { it.productCategory }
                .map { (categoryName, items) ->
                    CategoryProduct(
                        categoryId = categoryName,
                        name = categoryName,
                        color = Color.Black,
                        itemList = items.map {
                            ProductData(
                                id = it.id,
                                name = it.name,
                                amount = it.amount,
                                entity = it.unit.getEntityByShort(),
                                isBought = it.inCart
                            )
                        }
                    )
                }
        }
    }
}