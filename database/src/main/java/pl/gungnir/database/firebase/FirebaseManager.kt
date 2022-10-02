package pl.gungnir.database.firebase

import kotlinx.coroutines.flow.Flow
import pl.gungnir.database.data.ShoppingLists

interface FirebaseManager {

    fun getShoppingLists(): Flow<List<ShoppingLists>>
}