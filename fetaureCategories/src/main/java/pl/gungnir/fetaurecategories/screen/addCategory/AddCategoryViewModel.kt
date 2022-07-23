package pl.gungnir.fetaurecategories.screen.addCategory

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.gungnir.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    private val createCategoryUseCase: pl.gungnir.fetaurecategories.useCase.CreateCategoryUseCase
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
                params = pl.gungnir.fetaurecategories.data.Category(
                    id = 0,
                    name = newCategoryNameValue.value,
                    color = newCategoryColorValue.value
                )
            )
        }
    }
}