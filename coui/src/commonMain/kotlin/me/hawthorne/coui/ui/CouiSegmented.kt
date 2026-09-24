package me.hawthorne.coui.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class CouiSegment(
    val label: String,
)

@Composable
fun CouiSegmentedButton(
    segments: List<CouiSegment>,
    selectedIndex: Int,
    onSelectedIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    require(segments.isNotEmpty())
    require(selectedIndex in segments.indices)
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        segments.forEachIndexed { index, segment ->
            val selected = index == selectedIndex
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = CouiTokens.Components.TabLayoutHeight)
                    .clickable(enabled = enabled) { onSelectedIndexChange(index) },
                shape = when (index) {
                    0 -> RoundedCornerShape(
                        topStart = CouiTokens.Corners.Medium,
                        bottomStart = CouiTokens.Corners.Medium,
                    )
                    segments.lastIndex -> RoundedCornerShape(
                        topEnd = CouiTokens.Corners.Medium,
                        bottomEnd = CouiTokens.Corners.Medium,
                    )
                    else -> RoundedCornerShape(0.dp)
                },
                color = animateColorAsState(
                    targetValue = if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    },
                    label = "segmented-background",
                ).value,
                contentColor = animateColorAsState(
                    targetValue = if (selected) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    label = "segmented-content",
                ).value,
            ) {
                Text(
                    text = segment.label,
                    modifier = Modifier.padding(
                        horizontal = CouiTokens.Components.TabHorizontalPadding,
                        vertical = 10.dp,
                    ),
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}

@Composable
fun CouiToggleGroup(
    labels: List<String>,
    selectedIndex: Int,
    onSelectedIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    CouiSegmentedButton(
        segments = labels.map(::CouiSegment),
        selectedIndex = selectedIndex,
        onSelectedIndexChange = onSelectedIndexChange,
        modifier = modifier,
        enabled = enabled,
    )
}
