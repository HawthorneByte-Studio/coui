package me.hawthorne.coui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CouiSearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search",
    enabled: Boolean = true,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .height(CouiTokens.Components.SearchFieldHeight),
        enabled = enabled,
        singleLine = true,
        shape = CouiShape,
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = CouiTokens.Components.SearchFieldHintSize,
                ),
            )
        },
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            fontSize = CouiTokens.Components.SearchFieldTextSize,
        ),
        leadingIcon = leadingContent ?: { Icon(CouiIcons.Search, contentDescription = null) },
        trailingIcon = trailingContent,
    )
}

@Composable
fun CouiIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        content = content,
    )
}

@Composable
fun CouiEmptyState(
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    actionText: String? = null,
    onAction: () -> Unit = {},
    illustration: (@Composable () -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        illustration?.invoke()
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        if (actionText != null) {
            CouiButton(text = actionText, onClick = onAction)
        }
    }
}
