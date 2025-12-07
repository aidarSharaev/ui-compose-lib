package com.horizonguard.common_ui_compose_lib.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow

private const val SINGLE_LINE: Int = 1

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = SINGLE_LINE,
    textDecoration: TextDecoration? = null,
) {
    Text(
        text = text,
        fontFamily = manropeFamily,
        modifier = modifier,
        textAlign = textAlign,
        style = style,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        textDecoration = textDecoration,
    )
}

@Composable
fun Text(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium,
    color: Color = MaterialTheme.colorScheme.onSurface,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = SINGLE_LINE,
    textDecoration: TextDecoration? = null,
) {
    Text(
        text = text,
        fontFamily = manropeFamily,
        modifier = modifier,
        textAlign = textAlign,
        style = style,
        color = color,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines,
        textDecoration = textDecoration,
    )
}

