package pl.kurczaczkowe.bills.ui.components.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .then(modifier)
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}