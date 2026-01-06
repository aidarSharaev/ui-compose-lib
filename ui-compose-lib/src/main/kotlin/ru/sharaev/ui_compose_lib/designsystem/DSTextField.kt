package ru.sharaev.ui_compose_lib.designsystem


import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults.Container
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import ru.sharaev.ui_compose_lib.R

private const val SINGLE_LINE: Int = 1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DSTextField(
    value: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    letterSpacing: TextUnit = MaterialTheme.typography.titleMedium.letterSpacing,
    label: String? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    onValueChange: (String) -> Unit = {},
) {
    val source = remember { MutableInteractionSource() }

    if (label != null) {
        DSText(
            text = label,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_6))
        )
    }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle.copy(
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            letterSpacing = letterSpacing
        ),
        modifier = modifier
            .heightIn(min = dimensionResource(R.dimen.padding_45))
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.surfaceVariant),
        enabled = true,
        singleLine = true,
        maxLines = SINGLE_LINE,
        minLines = SINGLE_LINE,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    ) {
        TextFieldDefaults.DecorationBox(
            value = value,
            isError = isError,
            innerTextField = it,
            singleLine = true,
            enabled = true,
            visualTransformation = VisualTransformation.None,
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                top = dimensionResource(R.dimen.padding_0),
                bottom = dimensionResource(R.dimen.padding_0),
            ),
            trailingIcon = trailingIcon,
            placeholder = {
                DSText(
                    text = placeholder,
                    style = textStyle.copy(
                        color = MaterialTheme.colorScheme.tertiary,
                        letterSpacing = letterSpacing
                    ),
                )
            },
            interactionSource = source,
            container = {
                Container(
                    enabled = true,
                    isError = isError,
                    interactionSource = source,
                    modifier = Modifier,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        errorPlaceholderColor = MaterialTheme.colorScheme.error,
                        errorTextColor = MaterialTheme.colorScheme.error,
                        errorIndicatorColor = MaterialTheme.colorScheme.error,
                    ),
                    shape = MaterialTheme.shapes.small,
                    focusedBorderThickness = dimensionResource(R.dimen.padding_0),
                    unfocusedBorderThickness = dimensionResource(R.dimen.padding_0),
                )
            }
        )
    }
}
