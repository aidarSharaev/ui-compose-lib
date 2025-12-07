package com.horizonguard.common_ui_compose_lib.designsystem


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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.horizonguard.common_ui_compose_lib.R

@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes textIcon: Int? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
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
                Icon(
                    painter = painterResource(id = textIcon),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }

            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = textStyle,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes textIcon: Int? = null,
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

            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = textStyle,
            )
        }
    }
}
