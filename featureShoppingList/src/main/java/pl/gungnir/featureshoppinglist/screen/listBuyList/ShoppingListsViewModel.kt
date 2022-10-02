package pl.gungnir.featureshoppinglist.screen.listBuyList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.gungnir.base.BaseViewModel
import pl.gungnir.base.None
import pl.gungnir.components.toolbar.ToolbarManager
import pl.gungnir.featureshoppinglist.data.ShoppingListItem
import pl.gungnir.featureshoppinglist.useCase.GetBuyListsUseCase
import javax.inject.Inject

@HiltViewModel
class ShoppingListsViewModel @Inject constructor(
    val toolbarManager: ToolbarManager,
    private val getBuyListsUseCase: GetBuyListsUseCase
) : BaseViewModel<ShoppingListsEvent>() {

    val shoppingLists = mutableStateOf<List<ShoppingListItem>>(emptyList())

    fun onInit() {
        viewModelScope.launch {
            getBuyListsUseCase.execute(None) {
                collectShoppingListFromDB(it)
            }
        }
    }

    private fun collectShoppingListFromDB(list: Flow<List<ShoppingListItem>>) {
        viewModelScope.launch {
            list.collect {
                shoppingLists.value = it
            }
        }
    }

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