package ru.sharaev.ui_compose_lib.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import ru.sharaev.ui_compose_lib.R
import ru.sharaev.ui_compose_lib.utils.conditional

@Composable
fun AppScreenContainer(
    scrollEnabled: Boolean = true,
    @DrawableRes backgroundImage: Int? = null,
    topBar: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val imageRes by remember(backgroundImage) { mutableStateOf(backgroundImage) }

        imageRes?.let { image ->
            Crossfade(targetState = image, animationSpec = tween(500)) { targetImage ->
                Image(
                    painter = painterResource(targetImage),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight,
                )
            }
        }

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
}
