package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import ru.sharaev.ui_compose_lib.R

@Composable
fun DSLogoutSheet(
    onDismiss: () -> Unit,
    onLogout: () -> Unit,
) {
    DSBottomSheet(
        title = stringResource(R.string.logout),
        onDismiss = onDismiss,
    ) {
        DSText(
            text = stringResource(R.string.logout_description),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_16)),
            maxLines = Int.MAX_VALUE,
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(R.dimen.padding_4),
                alignment = Alignment.End,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.padding_24)),
        ) {
            TextButton(
                text = stringResource(R.string.cancel),
                textStyle = MaterialTheme.typography.titleSmall,
            ) {
                onDismiss()
            }

            DSButton(
                text = stringResource(R.string.ok),
                textStyle = MaterialTheme.typography.titleSmall,
                enabled = true,
            ) {
                onLogout()
            }
        }
    }
}
