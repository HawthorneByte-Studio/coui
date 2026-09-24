package me.hawthorne.coui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.heightIn

@Composable
fun CouiTopBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: (@Composable () -> Unit)? = null,
    onNavigationClick: () -> Unit = {},
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = CouiTokens.Elevation.TopBar,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = CouiTokens.Components.TopBarHeight)
                .padding(horizontal = CouiTokens.Spacing.Large, vertical = CouiTokens.Spacing.Small),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (navigationIcon != null) {
                IconButton(onClick = onNavigationClick, content = navigationIcon)
            }
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleLarge,
            )
            if (actions != null) {
                actions()
            }
        }
    }
}

@Composable
fun CouiCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = CouiShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = CouiTokens.Elevation.Card),
        content = content,
    )
}

@Composable
fun CouiButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier.heightIn(min = CouiTokens.Components.ButtonHeight),
        enabled = enabled,
        shape = CouiShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = CouiColors.Blue,
            contentColor = Color.White,
        ),
    ) {
        Text(text)
    }
}

@Composable
fun CouiButtonGroup(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(CouiTokens.Spacing.Medium),
        content = content,
    )
}
