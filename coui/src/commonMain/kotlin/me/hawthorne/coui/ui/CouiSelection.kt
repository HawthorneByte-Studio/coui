package me.hawthorne.coui.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues

data class CouiTabItem(
    val label: String,
)

@Composable
fun CouiTabLayout(
    items: List<CouiTabItem>,
    selectedIndex: Int,
    onSelectedIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    require(items.isNotEmpty())
    require(selectedIndex in items.indices)
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items.forEachIndexed { index, item ->
            val selected = index == selectedIndex
            Text(
                text = item.label,
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = CouiTokens.Components.TabLayoutHeight)
                    .clickable { onSelectedIndexChange(index) }
                    .padding(horizontal = CouiTokens.Components.TabHorizontalPadding, vertical = 10.dp),
                color = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                style = if (selected) {
                    MaterialTheme.typography.labelLarge
                } else {
                    MaterialTheme.typography.labelMedium
                },
            )
        }
    }
}

@Composable
fun CouiCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = enabled) { onCheckedChange(!checked) }
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = null,
            enabled = enabled,
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp),
            color = if (enabled) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            },
        )
    }
}

@Composable
fun CouiDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<String>,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier
            .widthIn(
                min = CouiTokens.Components.PopupListMinWidth,
                max = CouiTokens.Components.PopupListMaxWidth,
            )
            .padding(vertical = CouiTokens.Components.PopupListItemVerticalPadding),
        shape = RoundedCornerShape(CouiTokens.Components.PopupListContentRadius),
    ) {
        items.forEachIndexed { index, item ->
            DropdownMenuItem(
                modifier = Modifier.heightIn(min = CouiTokens.Components.PopupListItemMinHeight),
                contentPadding = PaddingValues(
                    horizontal = CouiTokens.Components.PopupListItemHorizontalPadding,
                ),
                text = {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.labelLarge,
                    )
                },
                onClick = {
                    onItemSelected(index)
                    onDismissRequest()
                },
            )
        }
    }
}
