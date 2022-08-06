package pl.gungnir.featureshoppinglist.screen.listBuyList

import pl.gungnir.base.SpecificEvent

sealed class ShoppingListsEvent : SpecificEvent
class OpenList(val listId: String) : ShoppingListsEvent()
object AddNewList : ShoppingListsEvent()
object OpenFilters : ShoppingListsEvent()