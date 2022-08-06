package pl.gungnir.featureshoppinglist.data

import java.time.LocalDate

class ShoppingListItem(
    val id: String,
    val lastUpdate: LocalDate,
    val listName: String,
    val restAmount: Int,
)