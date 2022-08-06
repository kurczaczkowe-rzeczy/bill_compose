package pl.gungnir.components.toolbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonToolbarView(
    modifier: Modifier = Modifier,
    type: ToolbarIconType?
) {
    type?.let {
        val iconDescription = when (type) {
            is ToolbarIconType.Additional -> {
                Pair(
                    Icons.Outlined.More,
                    "więcej"
                )
            }
            is ToolbarIconType.Add -> {
                Pair(
                    Icons.Outlined.Add,
                    "dodaj"
                )
            }
            is ToolbarIconType.Filter -> {
                Pair(
                    Icons.Outlined.FilterAlt,
                    "filtruj"
                )
            }
            is ToolbarIconType.Back ->  {
                Pair(
                    Icons.Outlined.ArrowBackIos,
                    "cofnij"
                )
            }
            is ToolbarIconType.Close ->  {
                Pair(
                    Icons.Outlined.Close,
                    "zamknij"
                )
            }
            is ToolbarIconType.Menu ->  {
                Pair(
                    Icons.Outlined.Menu,
                    "menu"
                )
            }
        }

        IconButton(
            modifier = modifier,
            onClick = type.onClick
        ) {
            Icon(
                imageVector = iconDescription.first,
                contentDescription = iconDescription.second,
                tint = MaterialTheme.colors.primary
            )
        }
    }
}

@Preview
@Composable
fun ButtonToolbarViewPreview() {
    ButtonToolbarView(type = ToolbarIconType.Additional {})
}