package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ru.sharaev.ui_compose_lib.R
import ru.sharaev.ui_compose_lib.utils.conditional

@Composable
fun AppScreenContainer(
    scrollEnabled: Boolean = true,
    topBar: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        topBar?.invoke()

        Column(
            modifier = Modifier
                .conditional(topBar == null) {
                    Modifier.windowInsetsPadding(WindowInsets.statusBars)
                }
                .consumeWindowInsets(WindowInsets.statusBars)
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))
                .windowInsetsPadding(WindowInsets.ime)
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(horizontal = dimensionResource(R.dimen.padding_16))
                .conditional(scrollEnabled) {
                    Modifier.verticalScroll(rememberScrollState())
                }
        ) {
            content()
        }
    }
}
