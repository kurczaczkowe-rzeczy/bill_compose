package pl.gungnir.featureshoppinglist.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.gungnir.base.BaseUseCase
import pl.gungnir.base.None
import pl.gungnir.database.domain.repository.BuyListRepository
import pl.gungnir.featureshoppinglist.data.ShoppingListItem
import java.time.LocalDate

class GetBuyListsUseCase(
    private val buyListRepository: BuyListRepository
) : BaseUseCase<Flow<List<ShoppingListItem>>, None>() {

    override suspend fun run(params: None): Flow<List<ShoppingListItem>> {
        return buyListRepository.getBuyLists().map {
            it.map {
                ShoppingListItem(
                    id = it.id,
                    lastUpdate = LocalDate.now(),
                    listName = it.listName,
                    restAmount = it.restAmount.toInt()
                )
            }
        }
    }
}