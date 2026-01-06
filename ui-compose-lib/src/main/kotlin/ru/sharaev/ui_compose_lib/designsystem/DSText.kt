package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow

private const val SINGLE_LINE: Int = 1

@Composable
fun DSText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = SINGLE_LINE,
    textDecoration: TextDecoration? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        style = style,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        textDecoration = textDecoration,
    )
}

@Composable
fun DSText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = SINGLE_LINE,
    textDecoration: TextDecoration? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        style = style,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        textDecoration = textDecoration,
    )
}

