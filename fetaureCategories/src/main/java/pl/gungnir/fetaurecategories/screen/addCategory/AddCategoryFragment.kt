package pl.gungnir.fetaurecategories.screen.addCategory

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.BaseFragment
import pl.gungnir.components.toolbar.ToolbarIconType
import pl.gungnir.components.toolbar.ToolbarState
import pl.gungnir.fetaurecategories.R

@AndroidEntryPoint
class AddCategoryFragment : BaseFragment<AddCategoryEvent, AddCategoryViewModel>() {

    override val viewModel: AddCategoryViewModel by viewModels()

    override fun onResume() {
        super.onResume()

        viewModel.toolbarManager.changeToolbar(
            toolbarState = ToolbarState(
                title = "Dodaj katerorię",
                navigationButton = ToolbarIconType.Back{
                    findNavController().navigateUp()
                }
            )
        )
    }

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