package pl.kurczaczkowe.bills.ui.screen.categoryList

import pl.kurczaczkowe.bills.data.model.Category

sealed class CategoryListState {
    object Loading: CategoryListState()
    object Empty : CategoryListState()
    class Success(val data: List<Category>) : CategoryListState()
    object Failure : CategoryListState()
}
