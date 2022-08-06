package pl.gungnir.fetaurecategories.screen.categoryList

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.BaseFragment
import pl.gungnir.components.toolbar.ToolbarIconType
import pl.gungnir.components.toolbar.ToolbarState
import pl.gungnir.fetaurecategories.R

@AndroidEntryPoint
class CategoryListFragment : BaseFragment<CategoryListEvent, CategoryListViewModel>() {

    override val viewModel: CategoryListViewModel by viewModels()

    override fun onResume() {
        super.onResume()

        viewModel.toolbarManager.changeToolbar(
            toolbarState = ToolbarState(
                "Dostępne kategorie",
                actionButton1 = ToolbarIconType.Add{
                    viewModel.onAddCategoryClick()
                }
            )
        )
    }

    @Composable
    override fun OnCreateView() {
        CategoryListScreen(
            listState = viewModel.categoryListState.value
        )
    }

    override fun handleEvent(event: CategoryListEvent) {
        super.handleEvent(event)

        if (event == OpenAddCategory){
            findNavController().navigate(R.id.action_categoryListFragment_to_addCategoryFragment)
        }
    }
}