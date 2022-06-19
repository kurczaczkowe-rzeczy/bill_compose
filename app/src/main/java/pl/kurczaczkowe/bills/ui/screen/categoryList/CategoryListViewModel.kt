package pl.kurczaczkowe.bills.ui.screen.categoryList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
                    if (it.isEmpty()){
                        categoryListState.value = CategoryListState.Empty
                        return@onSuccess
                    }

                    categoryListState.value = CategoryListState.Success(it)

                }
                response.onFailure {
                    categoryListState.value = CategoryListState.Failure
                }
            }
        }
    }
}
