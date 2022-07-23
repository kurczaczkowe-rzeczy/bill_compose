package pl.gungnir.fetaurecategories.screen.categoryList

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.BaseFragment

@AndroidEntryPoint
class CategoryListFragment : BaseFragment<CategoryListEvent, CategoryListViewModel>() {

    override val viewModel: CategoryListViewModel by viewModels()

    @Composable
    override fun OnCreateView() {
        CategoryListScreen(
            listState = viewModel.categoryListState.value
        )
    }
}