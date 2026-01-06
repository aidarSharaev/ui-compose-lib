package ru.sharaev.ui_compose_lib.designsystem

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import ru.sharaev.ui_compose_lib.R

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
fun DSButton(
    text: String?,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    leadingIcon: BaseDSIconModel? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
        ),
        onClick = onClick,
        enabled = enabled,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(R.dimen.padding_8),
                alignment = Alignment.CenterHorizontally
            )
        ) {
            leadingIcon?.Show(Modifier)

            text?.let {
                DSText(
                    text = it,
                    textAlign = TextAlign.Center,
                    style = textStyle.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                    ),
                )
            }
        }
    }
}

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes textIcon: Int? = null, // todo
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(),
        onClick = onClick,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(R.dimen.padding_8),
                alignment = Alignment.CenterHorizontally
            )
        ) {
            if (textIcon != null) {
                Icon(painter = painterResource(textIcon), contentDescription = "")
            }

            DSText(
                text = text,
                textAlign = TextAlign.Center,
                style = textStyle,
            )
        }
    }
}
