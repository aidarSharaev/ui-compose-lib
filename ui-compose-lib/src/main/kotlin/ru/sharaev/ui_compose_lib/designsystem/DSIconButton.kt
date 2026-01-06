package ru.sharaev.ui_compose_lib.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

abstract class BaseDSIconModel {

    abstract val tint: Color?

    abstract val description: String

    abstract val onClick: (() -> Unit)?

    abstract val enabled: Boolean

    @Composable
    abstract fun Show(modifier: Modifier)
}

class DSVectorModelImpl(
    val vector: ImageVector,
    override val tint: Color? = null,
    override val description: String = "",
    override val enabled: Boolean = true,
    override val onClick: (() -> Unit)? = null,
) : BaseDSIconModel() {

    @Composable
    override fun Show(modifier: Modifier) {
        Icon(
            imageVector = vector,
            contentDescription = description,
            tint = color(),
        )
    }
}

class DSPainterModelImpl(
    @DrawableRes val painter: Int,
    override val tint: Color? = null,
    override val description: String = "",
    override val enabled: Boolean = true,
    override val onClick: (() -> Unit)? = null,
) : BaseDSIconModel() {

    @Composable
    override fun Show(modifier: Modifier) {
        Icon(
            painter = painterResource(id = painter),
            contentDescription = description,
            tint = color(),
        )
    }
}

@Composable
private fun BaseDSIconModel.color(): Color = when {
    !enabled -> {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    }

    (tint != null) -> {
        tint ?: MaterialTheme.colorScheme.onSurface
    }

    else -> {
        MaterialTheme.colorScheme.onSurface
    }
}

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
