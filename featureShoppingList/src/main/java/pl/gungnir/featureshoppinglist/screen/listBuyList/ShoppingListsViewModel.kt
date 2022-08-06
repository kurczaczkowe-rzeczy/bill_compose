package pl.gungnir.featureshoppinglist.screen.listBuyList

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.gungnir.base.BaseViewModel
import pl.gungnir.components.toolbar.ToolbarManager
import javax.inject.Inject

@HiltViewModel
class ShoppingListsViewModel @Inject constructor(
    val toolbarManager: ToolbarManager
) : BaseViewModel<ShoppingListsEvent>() {

    fun addShoppingListClick() {
        sendEvent(AddNewList)
    }

    fun openFilterClick() {
        sendEvent(OpenFilters)
    }

    fun shoppingListClick(listId: Int) {
        sendEvent(OpenList(listId = listId))
    }
}