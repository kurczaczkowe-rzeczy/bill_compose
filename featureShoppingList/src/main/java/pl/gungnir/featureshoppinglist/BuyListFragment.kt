package pl.gungnir.featureshoppinglist

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.BaseFragment

@AndroidEntryPoint
class BuyListFragment : BaseFragment<BuyListEvent, BuyListViewModel>() {

    override val viewModel: BuyListViewModel by viewModels()

    @Composable
    override fun OnCreateView() {
        BuyListScreen(
            categories = viewModel.categories,
            onClickProduct = viewModel::onClickProduct,
            onCategoryClick = viewModel::onCategoryClick
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchCategories(0)
    }

}