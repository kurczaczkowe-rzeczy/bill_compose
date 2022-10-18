package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.database.data.ShoppingItem
import pl.gungnir.database.data.ShoppingLists

interface BuyListRepository {

    fun getBuyList(id: String): Flow<List<ShoppingItem>>
    fun getBuyLists(): Flow<List<ShoppingLists>>
}