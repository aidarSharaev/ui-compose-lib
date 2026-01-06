package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
private val topAppBarColors: TopAppBarColors
    @Composable get() = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Transparent,
    )

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DSTopBar(
    text: String?,
    centered: Boolean = true,
    leadingIconModel: BaseDSIconModel? = null,
    trailingIconModel: BaseDSIconModel? = null,
    customAction: (@Composable () -> Unit)? = null,
) {
    if (centered) {
        CenterAlignedTopAppBar(
            title = { text?.let { TopBarText(text = text) } },
            navigationIcon = {
                if (leadingIconModel != null) {
                    DSIconButton(iconModel = leadingIconModel)
                }
            },
            actions = {
                if (customAction != null) {
                    customAction()
                } else {
                    if (trailingIconModel != null) {
                        DSIconButton(iconModel = trailingIconModel)
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
            )
        )
    } else {
        TopAppBar(
            title = { text?.let { TopBarText(text = text) } },
            navigationIcon = {
                if (leadingIconModel != null) {
                    DSIconButton(iconModel = leadingIconModel)
                }
            },
            actions = {
                if (customAction != null) {
                    customAction()
                } else {
                    if (trailingIconModel != null) {
                        DSIconButton(iconModel = trailingIconModel)
                    }
                }
            },
            colors = topAppBarColors,
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DSTabRowTopBar(
    title: @Composable () -> Unit,
    actions: (@Composable () -> Unit)? = null,
) {
    TopAppBar(
        title = { title.invoke() },
        actions = { actions?.invoke() },
        colors = topAppBarColors,
    )
}

@Composable
private fun TopBarText(
    text: String,
    modifier: Modifier = Modifier,
) {
    DSText(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier,
    )
}
