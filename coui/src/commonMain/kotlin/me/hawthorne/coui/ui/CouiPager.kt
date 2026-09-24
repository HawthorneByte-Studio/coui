package me.hawthorne.coui.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CouiPager(
    pageCount: Int,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState(pageCount = { pageCount }),
    pageContent: @Composable (Int) -> Unit,
) {
    require(pageCount > 0)
    val scope = rememberCoroutineScope()
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
        ) { page ->
            pageContent(page)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = CouiTokens.Spacing.Medium),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(pageCount) { index ->
                val selected = index == pagerState.currentPage
                Surface(
                    modifier = Modifier
                        .padding(horizontal = CouiTokens.Components.PagerIndicatorSpacing)
                        .size(
                            if (selected) {
                                CouiTokens.Components.PagerIndicatorSelectedSize
                            } else {
                                CouiTokens.Components.PagerIndicatorSize
                            },
                        )
                        .clickable {
                            scope.launch { pagerState.animateScrollToPage(index) }
                        },
                    shape = CircleShape,
                    color = if (selected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.outlineVariant
                    },
                ) { }
            }
        }
    }
}
