package pl.gungnir.featureshoppinglist.screen.listBuyList

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.BaseFragment
import pl.gungnir.components.toolbar.ToolbarIconType
import pl.gungnir.components.toolbar.ToolbarState

@AndroidEntryPoint
class ShoppingListsFragment : BaseFragment<ShoppingListsEvent, ShoppingListsViewModel>() {

    override val viewModel: ShoppingListsViewModel by viewModels()

    @Composable
    override fun OnCreateView() {
        Text(text = "Listy zakupów", modifier = Modifier.clickable {
            viewModel.shoppingListClick(0)
        })
    }

    override fun handleEvent(event: ShoppingListsEvent) {
        super.handleEvent(event)

        when (event) {
            AddNewList -> openNotImplementDialog()
            OpenFilters -> openNotImplementDialog()
            is OpenList -> openNotImplementDialog()
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