package pl.gungnir.fetaurecategories.screen.addCategory

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.gungnir.base.BaseViewModel
import pl.gungnir.base.onSuccess
import pl.gungnir.components.toolbar.ToolbarManager
import pl.gungnir.fetaurecategories.data.Category
import pl.gungnir.fetaurecategories.useCase.CreateCategoryUseCase
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    val toolbarManager: ToolbarManager,
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
            val result = createCategoryUseCase.run(
                params = Category(
                    name = newCategoryNameValue.value,
                    color = newCategoryColorValue.value
                )
            )

            result.onSuccess {
                sendEvent(Back)
            }
        }
    }
}