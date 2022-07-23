package pl.kurczaczkowe.bills.ui.components.errorScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kurczaczkowe.bills.R
import pl.gungnir.base.theme.BillsTheme

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.general_error_title)
        )
        Text(
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.general_error_description, stringResource(id = R.string.support_email))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    BillsTheme { ErrorScreen() }
}