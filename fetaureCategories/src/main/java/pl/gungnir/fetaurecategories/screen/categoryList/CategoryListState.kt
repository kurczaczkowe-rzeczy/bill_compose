package pl.gungnir.fetaurecategories.screen.categoryList

sealed class CategoryListState {
    object Loading: CategoryListState()
    object Empty : CategoryListState()
    class Success(val data: List<pl.gungnir.fetaurecategories.data.Category>) : CategoryListState()
    object Failure : CategoryListState()
}
