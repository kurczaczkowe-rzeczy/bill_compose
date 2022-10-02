package pl.gungnir.featureshoppinglist.screen.listBuyList

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.BaseFragment
import pl.gungnir.components.toolbar.ToolbarIconType
import pl.gungnir.components.toolbar.ToolbarState
import pl.gungnir.featureshoppinglist.R

@AndroidEntryPoint
class ShoppingListsFragment : BaseFragment<ShoppingListsEvent, ShoppingListsViewModel>() {

    override val viewModel: ShoppingListsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onInit()
    }

    @Composable
    override fun OnCreateView() {
        ShoppingListsScreen(
            list = viewModel.shoppingLists.value,
            onItemClick = viewModel::shoppingListClick
        )
    }

    override fun handleEvent(event: ShoppingListsEvent) {
        super.handleEvent(event)

        when (event) {
            AddNewList -> openNotImplementDialog()
            OpenFilters -> openNotImplementDialog()
            is OpenList -> {
                findNavController().navigate(R.id.action_shoppingListsFragment_to_buyListFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.toolbarManager.changeToolbar(
            toolbarState = ToolbarState(
                actionButton1 = ToolbarIconType.Add {
                    viewModel.addShoppingListClick()
                },
                actionButton2 = ToolbarIconType.Filter {
                    viewModel.openFilterClick()
                }
            )
        )
    }
}