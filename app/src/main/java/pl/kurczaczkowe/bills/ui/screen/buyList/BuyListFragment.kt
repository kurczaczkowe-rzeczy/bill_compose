package pl.kurczaczkowe.bills.ui.screen.buyList

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.kurczaczkowe.bills.ui.screen.base.*

@AndroidEntryPoint
class BuyListFragment : BaseFragment<BuyListEvent, BuyListViewModel>() {

    override val viewModel: BuyListViewModel by viewModels()

    @Composable
    override fun OnCreateView() {
        BuyListScreen()
    }

}