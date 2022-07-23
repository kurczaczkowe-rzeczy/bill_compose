package pl.gungnir.fetaurecategories.screen.categoryList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.gungnir.base.BaseViewModel
import pl.gungnir.base.None
import pl.gungnir.base.onFailure
import pl.gungnir.base.onSuccess
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoriesUseCase: pl.gungnir.fetaurecategories.useCase.GetCategoryListUseCase
) : BaseViewModel<CategoryListEvent>() {

    val categoryListState = mutableStateOf<CategoryListState>(CategoryListState.Loading)

    init {
        categoryListState.value = CategoryListState.Loading
        viewModelScope.launch {
            getCategoriesUseCase.execute(None) { response ->
                response.onSuccess {
                    viewModelScope.launch {
                        handleGetCategorySuccess(it)
                    }
                }
                response.onFailure {
                    categoryListState.value = CategoryListState.Failure
                }
            }
        }
    }

    private suspend fun handleGetCategorySuccess(response: Flow<List<pl.gungnir.fetaurecategories.data.Category>>){
        response.collect {
            if (it.isEmpty()) {
                categoryListState.value = CategoryListState.Empty
                return@collect
            }

            categoryListState.value = CategoryListState.Success(it)
        }
    }
}
