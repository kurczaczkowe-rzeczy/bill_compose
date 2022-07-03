package pl.kurczaczkowe.bills.ui.screen.addCategory

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.kurczaczkowe.bills.data.model.Category
import pl.kurczaczkowe.bills.domain.usecase.CreateCategoryUseCase
import pl.kurczaczkowe.bills.ui.screen.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    private val createCategoryUseCase: CreateCategoryUseCase
) : BaseViewModel<AddCategoryEvent>() {

    val newCategoryNameValue = mutableStateOf("")
    val newCategoryColorValue = mutableStateOf(Color.Blue)

    fun onInitInputValue(input: String) {
        newCategoryNameValue.value = input
    }

    fun onInputChange(input: String) {
        newCategoryNameValue.value = input
    }

    fun onColorChange(value: Color){
        newCategoryColorValue.value = value
    }

    fun onSaveClick() {
        viewModelScope.launch {
            createCategoryUseCase.run(
                params = Category(
                    id = 0,
                    name = newCategoryNameValue.value,
                    color = newCategoryColorValue.value
                )
            )
        }
    }
}