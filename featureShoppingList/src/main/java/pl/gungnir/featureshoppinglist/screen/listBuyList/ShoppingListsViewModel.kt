package pl.gungnir.featureshoppinglist.screen.listBuyList

import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.gungnir.base.BaseViewModel
import pl.gungnir.components.toolbar.ToolbarManager
import pl.gungnir.featureshoppinglist.data.ShoppingListItem
import javax.inject.Inject

@HiltViewModel
class ShoppingListsViewModel @Inject constructor(
    val toolbarManager: ToolbarManager
) : BaseViewModel<ShoppingListsEvent>() {

    val shoppingLists = mutableStateOf<List<ShoppingListItem>>(emptyList())

    fun addShoppingListClick() {
        sendEvent(AddNewList)
    }

    fun openFilterClick() {
        sendEvent(OpenFilters)
    }

    fun shoppingListClick(listId: String) {
        sendEvent(OpenList(listId = listId))
    }
}