package pl.gungnir.components.toolbar

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBackIos
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.gungnir.base.theme.BillsTheme

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
    actionIcons: @Composable () -> Unit = {},

    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
            .then(modifier),
    ) {
        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            navigationIcon()
        }
        Box(modifier = Modifier.align(Alignment.Center)) {
            title()
        }
        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            actionIcons()
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ToolbarPreview() = BillsTheme {
    Toolbar(
        title = {
            Text(
                text = "Header",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBackIos,
                    contentDescription = "back",
                    tint = MaterialTheme.colors.primary
                )
            }
        },
        actionIcons = {
            Row{
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "add",
                        tint = MaterialTheme.colors.primary
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.FilterAlt,
                        contentDescription = "filter",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ToolbarDarkPreview() = BillsTheme {
    Toolbar(
        title = {
            Text(
                text = "Header",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBackIos,
                    contentDescription = "back",
                    tint = MaterialTheme.colors.primary
                )
            }
        },
        actionIcons = {
            Row{
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "add",
                        tint = MaterialTheme.colors.primary
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.FilterAlt,
                        contentDescription = "filter",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    )
}