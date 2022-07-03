package pl.kurczaczkowe.bills.ui.screen.addCategory

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.kurczaczkowe.bills.R
import pl.kurczaczkowe.bills.ui.screen.base.*

@AndroidEntryPoint
class AddCategoryFragment : BaseFragment<AddCategoryEvent, AddCategoryViewModel>() {

    override val viewModel: AddCategoryViewModel by viewModels()

    @Composable
    override fun OnCreateView() {
        viewModel.onInitInputValue(getString(R.string.add_category_initial_value))

        AddCategoryScreen(
            color = viewModel.newCategoryColorValue,
            onColorChange = viewModel::onColorChange,
            inputValue = viewModel.newCategoryNameValue,
            onInputValue = viewModel::onInputChange,
            onSaveButtonClick = viewModel::onSaveClick
        )
    }
}