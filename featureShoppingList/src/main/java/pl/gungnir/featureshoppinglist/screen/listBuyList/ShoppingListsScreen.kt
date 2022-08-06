package pl.gungnir.featureshoppinglist.screen.listBuyList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import pl.gungnir.base.theme.Gray
import pl.gungnir.featureshoppinglist.R
import pl.gungnir.featureshoppinglist.components.shoppingListsItem.ShoppingListsItem
import pl.gungnir.featureshoppinglist.data.ShoppingListItem
import java.time.format.DateTimeFormatter

@Composable
fun ShoppingListsScreen(
    list: List<ShoppingListItem>,
    onItemClick: (String) -> Unit
) {
    LazyColumn {
        items(list) { item ->
            ShoppingListsItem(
                modifier = Modifier
                    .clickable {
                        onItemClick(item.id)
                    }
                    .padding(16.dp),
                additionalInfo = {
                    Text(
                        text = LocalContext.current.resources
                            .getQuantityString(R.plurals.products, item.restAmount),
                        color = Gray,
                        style = MaterialTheme.typography.body2
                    )
                }
            ) {
                Text(
                    text = item.lastUpdate.format(DateTimeFormatter.BASIC_ISO_DATE),
                    color = Gray,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.listName,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h3
                )
            }

            Divider(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}