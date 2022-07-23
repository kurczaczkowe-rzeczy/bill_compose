package pl.gungnir.fetaurecategories.screen.addCategory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.color.ARGBPickerState
import com.vanpra.composematerialdialogs.color.ColorPalette
import com.vanpra.composematerialdialogs.color.colorChooser
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.vanpra.composematerialdialogs.title
import pl.gungnir.fetaurecategories.R
import pl.gungnir.components.R as BaseR
import pl.gungnir.components.button.Button
import pl.gungnir.base.theme.BillsTheme

@Composable
fun AddCategoryScreen(
    modifier: Modifier = Modifier,
    inputValue: MutableState<String> = mutableStateOf(""),
    color: MutableState<Color> = mutableStateOf(MaterialTheme.colors.primary),
    onInputValue: (String) -> Unit = {},
    onColorChange: (Color) -> Unit = {},
    onSaveButtonClick: () -> Unit = {},
) {
    val colorPickerShow = rememberMaterialDialogState()
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
                .padding(horizontal = 24.dp)
                .then(modifier),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.add_category_input_label),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(48.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = color.value, shape = RoundedCornerShape(12.dp))
                    .padding(vertical = 4.dp)
                    .clickable {
                        colorPickerShow.show()
                    },
                text = color.value.value.toInt().toString(),
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                value = inputValue.value,
                onValueChange = onInputValue,
                label = {
                    Text(text = stringResource(id = R.string.category_name))
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { onSaveButtonClick() }
                )
            )
        }

        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = onSaveButtonClick
        ) {
            Text(text = stringResource(id = BaseR.string.save))
        }
    }

    MaterialDialog(dialogState = colorPickerShow) {
        title(res = R.string.chooseColor)
        colorChooser(
            colors = ColorPalette.Primary,
            argbPickerState = ARGBPickerState.WithoutAlphaSelector,
            onColorSelected = onColorChange,
            waitForPositiveButton = false
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddCategoryPreview() {
    BillsTheme {
        val color = remember { mutableStateOf(Color.Green) }
        val name = remember { mutableStateOf("") }
        AddCategoryScreen(
            color = color,
            onColorChange = { color.value = it },
            inputValue = name,
            onInputValue = { name.value = it }
        )
    }
}