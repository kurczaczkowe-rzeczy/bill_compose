package pl.kurczaczkowe.bills.ui.screen.categoryList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.domain.None
import pl.kurczaczkowe.bills.domain.onFailure
import pl.kurczaczkowe.bills.domain.onSuccess
import pl.kurczaczkowe.bills.domain.usecase.GetCategoryListUseCase
import pl.kurczaczkowe.bills.ui.screen.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoryListUseCase
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

    private suspend fun handleGetCategorySuccess(response: Flow<List<Category>>){
        response.collect {
            if (it.isEmpty()) {
                categoryListState.value = CategoryListState.Empty
                return@collect
            }

            categoryListState.value = CategoryListState.Success(it)
        }
    }
}
