package pl.gungnir.database.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.gungnir.database.data.ShoppingItem
import pl.gungnir.database.data.ShoppingLists
import pl.gungnir.database.firebase.FirebaseManager
import javax.inject.Inject

class BuyListRepositoryImpl @Inject constructor(
    private val firebaseManager: FirebaseManager
): BuyListRepository {

    override fun getBuyList(id: String): Flow<List<ShoppingItem>> {
        return firebaseManager.getShoppingItems(id)
    }

    override fun getBuyLists(): Flow<List<ShoppingLists>> {
        return firebaseManager.getShoppingLists()
    }
}