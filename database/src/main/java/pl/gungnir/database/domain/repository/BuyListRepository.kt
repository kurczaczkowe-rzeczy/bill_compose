package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.database.data.ShoppingLists
import pl.gungnir.database.entity.CategoryEntity

interface BuyListRepository {

    fun getBuyList(id: Int): Either<Failure, Flow<List<CategoryEntity>>>
    fun getBuyLists(): Flow<List<ShoppingLists>>
}