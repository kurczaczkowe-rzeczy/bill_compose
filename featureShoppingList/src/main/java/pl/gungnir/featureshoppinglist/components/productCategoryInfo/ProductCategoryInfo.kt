package pl.gungnir.featureshoppinglist.components.productCategoryInfo

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.gungnir.featureshoppinglist.R

@Composable
fun ProductCategoryInfo(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    categoryName: @Composable RowScope.() -> Unit = {},
    subtitle: @Composable (RowScope.() -> Unit)? = null,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        categoryName()

        subtitle?.let {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                subtitle()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCategoryPreview() {
    val (showMore, setShowMore) = remember { mutableStateOf(false) }

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

    ProductCategoryInfo(
        modifier = Modifier.background(Color.Red),
        onClick = { setShowMore(!showMore) },
        categoryName = {
            Text(
                text = "Category name",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )

        }
    ) {
        Text(
            text = "Left: 0",
            style = MaterialTheme.typography.subtitle1,
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