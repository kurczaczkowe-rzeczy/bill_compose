package pl.gungnir.featureshoppinglist.components.shoppingListsItem

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.base.theme.BillsTheme
import pl.gungnir.base.theme.Gray

@Composable
fun ShoppingListsItem(
    modifier: Modifier = Modifier,
    additionalInfo: @Composable RowScope.() -> Unit = {},
    content: @Composable ColumnScope.() -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                content()

            }
            additionalInfo()
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ShoppingListsItemPreview() = BillsTheme {
    ShoppingListsItem(
        additionalInfo = {
            Text(
                text = "2 produkty",
                color = Gray,
                style = MaterialTheme.typography.body2
            )
        }
    ) {
        Text(
            text = "25.05.2021",
            color = Gray,
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Lista zakupów",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShoppingListsItemDarkPreview() = BillsTheme {
    ShoppingListsItem(
        additionalInfo = {
            Text(
                text = "2 produkty",
                color = Gray,
                style = MaterialTheme.typography.body2
            )
        }
    ) {
        Text(
            text = "25.05.2021",
            color = Gray,
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Lista zakupów",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h3
        )
    }
}