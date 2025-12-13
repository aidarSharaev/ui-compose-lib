package ru.sharaev.ui_compose_lib.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBar(
    text: String,
    centered: Boolean = true,
    showNavIcon: Boolean = true,
    @DrawableRes showTrailingIconId: Int? = null,
    customAction: (@Composable () -> Unit)? = null,
    trailingIconEnabled: Boolean = true,
    onTrailingClick: () -> Unit = {},
    onNavClick: () -> Unit = {},
) {
    if (centered) {
        CenterAlignedTopAppBar(
            title = { TopBarText(text = text) },
            navigationIcon = { CrierTopBarNavIcon(show = showNavIcon, onNavClick = onNavClick) },
            actions = {
                if (customAction != null) {
                    customAction()
                } else {
                    showTrailingIconId?.let {
                        IconButton(onClick = onTrailingClick, enabled = trailingIconEnabled) {
                            Icon(
                                painter = painterResource(it),
                                contentDescription = "",
                                tint = if (trailingIconEnabled) {
                                    MaterialTheme.colorScheme.onSurface
                                } else {
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                                },
                            )
                        }
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
            )
        )
    } else {
        TopAppBar(
            title = { TopBarText(text = text) },
            navigationIcon = { CrierTopBarNavIcon(show = showNavIcon, onNavClick = onNavClick) },
            actions = {
                if (customAction != null) {
                    customAction()
                } else {
                    showTrailingIconId?.let {
                        IconButton(onClick = onTrailingClick, enabled = trailingIconEnabled) {
                            Icon(
                                painter = painterResource(it),
                                contentDescription = "",
                                tint = if (trailingIconEnabled) {
                                    MaterialTheme.colorScheme.onSurface
                                } else {
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                                },
                            )
                        }
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
            )
        )
    }
}

@Composable
private fun CrierTopBarNavIcon(show: Boolean, onNavClick: () -> Unit) {
    if (show) {
        IconButton(onClick = onNavClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
fun TopBarText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier,
    )
}
