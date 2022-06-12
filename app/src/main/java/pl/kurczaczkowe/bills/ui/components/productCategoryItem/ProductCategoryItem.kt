package pl.kurczaczkowe.bills.ui.components.productCategoryItem

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductCategoryItem(
    modifier: Modifier = Modifier,
    product: ProductData,
    backgroundColor: Color = Color.White,
    onClick: (Int) -> Unit = {},
) {
    val colorText by animateColorAsState(targetValue = if (product.isBought) MaterialTheme.colors.onBackground.copy(alpha = 0.6f) else MaterialTheme.colors.onBackground)
    val width by animateFloatAsState(targetValue = if(product.isBought) 1f else 0f)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable { onClick(product.id) }
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .then(modifier),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.body2,
                color = colorText
            )
            Text(
                text = "${product.amount} ${product.entity.getUnitShort()}",
                style = MaterialTheme.typography.body2,
                color = colorText
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth(width)
                .height(1.dp)
                .background(color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f))
                .align(Alignment.CenterStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    val product = remember{
        mutableStateOf(
            ProductData(
                id = 0, name = "Jabłko", amount = 1.0, entity = Entity.KILOGRAM, isBought = true
            )
        )
    }

    ProductCategoryItem(
        product = product.value,
        backgroundColor = Color.LightGray,
        onClick = {
            product.value = product.value.copy(isBought = !product.value.isBought)
        }
    )
}