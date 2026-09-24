package me.hawthorne.coui.ui

import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun CouiPullRefresh(
    refreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    refreshThreshold: androidx.compose.ui.unit.Dp = 72.dp,
    content: @Composable () -> Unit,
) {
    require(refreshThreshold > 0.dp)
    val density = androidx.compose.ui.platform.LocalDensity.current
    val thresholdPx = with(density) { refreshThreshold.toPx() }
    var dragDistance by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(refreshing) {
        if (refreshing) dragDistance = 0f
    }
    val pullOffset = (dragDistance * 0.5f).coerceAtMost(thresholdPx)
    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(refreshing, thresholdPx) {
                detectVerticalDragGestures(
                    onVerticalDrag = { change, dragAmount ->
                        if (!refreshing && dragAmount > 0f) {
                            dragDistance += dragAmount
                            change.consume()
                        }
                    },
                    onDragEnd = {
                        if (!refreshing && dragDistance >= thresholdPx) {
                            onRefresh()
                        }
                        dragDistance = 0f
                    },
                    onDragCancel = { dragDistance = 0f },
                )
            },
        contentAlignment = Alignment.TopCenter,
    ) {
        Box(modifier = Modifier.offset(y = with(density) { pullOffset.toDp() })) {
            content()
        }
        if (refreshing) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = CouiTokens.Components.PullRefreshIndicatorTopPadding)
                    .size(CouiTokens.Components.PullRefreshIndicatorSize),
                color = CouiColors.Blue,
                strokeWidth = 3.dp,
            )
        } else if (dragDistance > 0f) {
            CircularProgressIndicator(
                progress = { (dragDistance / thresholdPx).coerceIn(0f, 1f) },
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = CouiTokens.Components.PullRefreshIndicatorTopPadding)
                    .size(CouiTokens.Components.PullRefreshIndicatorSize)
                    .offset(y = with(density) { pullOffset.toDp() }),
                color = CouiColors.Blue,
                strokeWidth = 3.dp,
            )
        }
    }
}
