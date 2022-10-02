package pl.gungnir.database.firebase

import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import pl.gungnir.database.data.ShoppingLists
import javax.inject.Inject

class FirebaseManagerImpl @Inject constructor() : FirebaseManager {

    override fun getShoppingLists(): Flow<List<ShoppingLists>> {
        return Firebase.firestore.collection("shoppingLists")
            .snapshotFlow()
            .map {
                it.documents.map { document ->
                    ShoppingLists(
                        id = document.id,
                        listName = document.data?.getOrDefault("name", "") as String,
                        restAmount = document.data?.getOrDefault("productsAmount", 0) as Long
                    )
                }
            }

    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun Query.snapshotFlow(): Flow<QuerySnapshot> = callbackFlow {
    val listenerRegistration = addSnapshotListener { value, error ->
        if (error != null) {
            close()
            return@addSnapshotListener
        }
        if (value != null)
            trySend(value)
    }
    awaitClose {
        listenerRegistration.remove()
    }
}