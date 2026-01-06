package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DSIconButton(
    iconModel: BaseDSIconModel,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
) {
    IconButton(
        onClick = iconModel.onClick ?: throw IllegalArgumentException("No action for $iconModel"),
        modifier = modifier,
        enabled = iconModel.enabled,
    ) {
        iconModel.Show(modifier = iconModifier)
    }
}
