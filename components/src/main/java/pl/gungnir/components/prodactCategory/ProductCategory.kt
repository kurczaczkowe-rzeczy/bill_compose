package pl.gungnir.components.prodactCategory

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pl.gungnir.components.productCategoryInfo.ProductCategoryInfo
import pl.gungnir.components.R

enum class ProductCategoryType {
    PRODUCTS,
    CATEGORY_ITEM
}

@Composable
fun ProductCategory(
    modifier: Modifier = Modifier,
    getRestToBuy: Int = -1,
    showMore: Boolean = false,
    type: ProductCategoryType = ProductCategoryType.PRODUCTS,
    setShowMore: (Boolean) -> Unit = {},
    categoryColor: Color,
    category: @Composable RowScope.() -> Unit,
) {
    val iconAngle by animateFloatAsState(
        targetValue = if (showMore) {
            0f
        } else {
            180f
        }
    )
    val iconDescription = if (showMore) {
        stringResource(id = R.string.show_more)
    } else {
        stringResource(id = R.string.show_less)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        ProductCategoryInfo(
            modifier = Modifier.background(categoryColor),
            categoryName = category,
            onClick = {
                setShowMore(!showMore)
            }
        ) {
            if (type == ProductCategoryType.PRODUCTS) {
                Text(
                    text = stringResource(id = R.string.left_n, getRestToBuy),
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Icon(
                    modifier = Modifier.rotate(iconAngle),
                    imageVector = Icons.Outlined.ExpandMore,
                    contentDescription = iconDescription,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductCategoryPreview() {
    val (showMore, setShowMore) = remember { mutableStateOf(false) }

    ProductCategory(
        categoryColor = Color.Red,
        showMore = showMore,
        setShowMore = setShowMore,
        getRestToBuy = 2,
        category = {
            Text(
                text = stringResource(id = R.string.category_name),
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        }
    )
}