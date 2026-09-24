package me.hawthorne.coui.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class CouiNavigationItem(
    val label: String,
    val selected: Boolean,
    val onClick: () -> Unit,
    val badge: String? = null,
    val icon: (@Composable () -> Unit)? = null,
)

@Composable
fun CouiNavigationBar(
    items: List<CouiNavigationItem>,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = CouiTokens.Elevation.Navigation,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items.forEach { item ->
                CouiNavigationBarItem(item = item, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun CouiNavigationBarItem(
    item: CouiNavigationItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable(onClick = item.onClick)
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Surface(
                modifier = Modifier.size(32.dp),
                shape = CircleShape,
                color = if (item.selected) {
                    CouiColors.BlueContainer
                } else {
                    Color.Transparent
                },
            ) {
                Box(contentAlignment = Alignment.Center) {
                    if (item.icon != null) {
                        item.icon()
                    } else {
                        Text(
                            text = item.label.take(1),
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                }
            }
            if (item.badge != null) {
                CouiBadge(label = item.badge)
            }
        }
        Text(
            text = item.label,
            style = MaterialTheme.typography.labelMedium,
            color = if (item.selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            },
        )
    }
}

@Composable
fun CouiBadge(
    label: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onError,
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}
