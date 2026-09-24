package me.hawthorne.coui.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CouiChip(
    label: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier.then(
            if (onClick != null) {
                Modifier.clickable(enabled = enabled, onClick = onClick)
            } else {
                Modifier
            },
        ),
        shape = RoundedCornerShape(CouiTokens.Corners.Medium),
        color = animateColorAsState(
            targetValue = if (selected) {
                CouiColors.BlueContainer
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            },
            label = "chip-background",
        ).value,
        contentColor = animateColorAsState(
            targetValue = if (selected) {
                CouiColors.BlueOnContainer
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            },
            label = "chip-content",
        ).value,
    ) {
        Text(
            text = label,
            modifier = Modifier
                .heightIn(min = CouiTokens.Components.ChipMinHeight)
                .padding(horizontal = CouiTokens.Components.ChipHorizontalPadding),
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Composable
fun CouiStepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: IntRange = 0..99,
    enabled: Boolean = true,
) {
    require(!valueRange.isEmpty())
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CouiIconButton(
            onClick = { onValueChange((value - 1).coerceIn(valueRange)) },
            enabled = enabled && value > valueRange.first,
        ) {
            Text("-")
        }
        Text(
            text = value.toString(),
            modifier = Modifier.padding(horizontal = 12.dp),
            style = MaterialTheme.typography.titleMedium,
        )
        CouiIconButton(
            onClick = { onValueChange((value + 1).coerceIn(valueRange)) },
            enabled = enabled && value < valueRange.last,
        ) {
            Text("+")
        }
    }
}

@Composable
fun CouiInfoBanner(
    title: String,
    modifier: Modifier = Modifier,
    message: String? = null,
    actionText: String? = null,
    onAction: () -> Unit = {},
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = CouiShape,
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleSmall)
            if (message != null) {
                Text(
                    text = message,
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            if (actionText != null) {
                CouiButton(
                    text = actionText,
                    onClick = onAction,
                    modifier = Modifier.padding(top = 12.dp),
                )
            }
        }
    }
}
