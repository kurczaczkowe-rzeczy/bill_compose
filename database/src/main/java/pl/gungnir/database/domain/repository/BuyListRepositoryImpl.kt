package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.base.Either
import pl.gungnir.base.Failure
import pl.gungnir.base.Unknown
import pl.gungnir.base.left
import pl.gungnir.database.data.ShoppingLists
import pl.gungnir.database.entity.CategoryEntity
import pl.gungnir.database.firebase.FirebaseManager
import javax.inject.Inject

class BuyListRepositoryImpl @Inject constructor(
    private val firebaseManager: FirebaseManager
): BuyListRepository {

    override fun getBuyList(id: Int): Either<Failure, Flow<List<CategoryEntity>>> {
        return Unknown.left()
    }

    override fun getBuyLists(): Flow<List<ShoppingLists>> {
        return firebaseManager.getShoppingLists()
    }
}