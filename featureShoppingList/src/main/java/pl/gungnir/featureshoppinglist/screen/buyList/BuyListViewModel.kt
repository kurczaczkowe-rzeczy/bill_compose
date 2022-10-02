package pl.gungnir.featureshoppinglist.screen.buyList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pl.gungnir.base.BaseViewModel
import pl.gungnir.base.onSuccess
import pl.gungnir.featureshoppinglist.data.CategoryProduct
import pl.gungnir.featureshoppinglist.useCase.GetBuyListUseCase
import javax.inject.Inject

@HiltViewModel
class BuyListViewModel @Inject constructor(
    private val getBuyListUseCase: GetBuyListUseCase
) : BaseViewModel<BuyListEvent>() {

    val categories = mutableStateOf(emptyList<CategoryProduct>())

    fun fetchCategories(listId: Int) {
        viewModelScope.launch {
            getBuyListUseCase.execute(listId) {
                it.onSuccess {
                    viewModelScope.launch {
                        categories.value = it.first()
                    }
                }
            }
        }
    }

    fun onClickProduct(categoryId: Int, productId: Int) {
        categories.value = categories.value.map {
            if (it.categoryId == categoryId) {
                val newList = it.itemList.map {
                    if (it.id == productId) {
                        it.copy(isBought = !it.isBought)
                    } else {
                        it
                    }
                }
                it.copy(
                    itemList = newList
                )
            } else {
                it
            }
        }
    }

    fun onCategoryClick(categoryId: Int) {
        categories.value = categories.value.map {
            if (it.categoryId == categoryId) {
                it.copy(
                    isVisible = !it.isVisible
                )
            } else {
                it
            }
        }
    }
}