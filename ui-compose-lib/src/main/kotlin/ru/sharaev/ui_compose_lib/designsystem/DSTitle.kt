package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import ru.sharaev.ui_compose_lib.R

@Composable
fun DSTitle(
    value: String,
    modifier: Modifier = Modifier,
    titleAlign: TextAlign = TextAlign.Start,
) {
    DSText(
        text = value,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_6)),
        style = MaterialTheme.typography.titleLarge,
        textAlign = titleAlign,
    )
}

@Composable
fun DSHeadlineLabel(
    value: String,
    modifier: Modifier = Modifier,
    titleAlign: TextAlign = TextAlign.Start,
) {
    DSText(
        text = value,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_6)),
        style = MaterialTheme.typography.headlineMedium,
        textAlign = titleAlign,
    )
}
