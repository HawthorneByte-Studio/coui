package me.hawthorne.coui.example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import me.hawthorne.coui.ui.CouiButton
import me.hawthorne.coui.ui.CouiButtonGroup
import me.hawthorne.coui.ui.CouiCard
import me.hawthorne.coui.ui.CouiCheckbox
import me.hawthorne.coui.ui.CouiDate
import me.hawthorne.coui.ui.CouiDatePicker
import me.hawthorne.coui.ui.CouiEmptyState
import me.hawthorne.coui.ui.CouiInfoBanner
import me.hawthorne.coui.ui.CouiIcons
import me.hawthorne.coui.ui.CouiIconButton
import me.hawthorne.coui.ui.CouiListItem
import me.hawthorne.coui.ui.CouiRadioButton
import me.hawthorne.coui.ui.CouiSearchField
import me.hawthorne.coui.ui.CouiSegment
import me.hawthorne.coui.ui.CouiSegmentedButton
import me.hawthorne.coui.ui.CouiSection
import me.hawthorne.coui.ui.CouiSlider
import me.hawthorne.coui.ui.CouiStepper
import me.hawthorne.coui.ui.CouiSwitch
import me.hawthorne.coui.ui.CouiTextField
import me.hawthorne.coui.ui.CouiTime
import me.hawthorne.coui.ui.CouiTimePicker
import me.hawthorne.coui.ui.CouiBadge
import me.hawthorne.coui.ui.CouiChip
import me.hawthorne.coui.ui.CouiDivider
import me.hawthorne.coui.ui.CouiDropdownMenu
import me.hawthorne.coui.ui.CouiPager
import me.hawthorne.coui.ui.CouiPreferenceCategory
import me.hawthorne.coui.ui.CouiPreferenceItem
import me.hawthorne.coui.ui.CouiProgressIndicator
import me.hawthorne.coui.ui.CouiTabItem
import me.hawthorne.coui.ui.CouiTabLayout
import me.hawthorne.coui.ui.CouiTooltip
import me.hawthorne.coui.ui.CouiPullRefresh

@Composable
fun HomeScreen(onDialog: () -> Unit, onSheet: () -> Unit, onSnackbar: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ExamplePageHeader("Home", "Explore the reusable COUI foundation")
        CouiInfoBanner(title = "COUI Showcase", message = "Reusable Compose UI components.")
        CouiCard {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Overlay playground", style = MaterialTheme.typography.titleMedium)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    CouiButton(text = "Dialog", onClick = onDialog)
                    CouiButton(text = "Sheet", onClick = onSheet)
                    CouiButton(text = "Snackbar", onClick = onSnackbar)
                }
            }
        }
        CouiEmptyState(title = "Explore the component pages", description = "Controls and pickers are interactive.")
    }
}

@Composable
fun ControlsScreen() {
    var query by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var enabled by remember { mutableStateOf(true) }
    var checked by remember { mutableStateOf(false) }
    var slider by remember { mutableStateOf(0.5f) }
    var stepper by remember { mutableStateOf(2) }
    var selected by remember { mutableStateOf(0) }
    var segment by remember { mutableStateOf(0) }
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ExamplePageHeader("Controls", "Forms, selections, and compact actions")
        CouiCard {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                CouiSearchField(query = query, onQueryChange = { query = it }, placeholder = "Search components")
                CouiTextField(value = text, onValueChange = { text = it }, label = "Text field")
                CouiSwitch(checked = enabled, onCheckedChange = { enabled = it }, label = "Enabled controls")
                CouiCheckbox(checked = checked, onCheckedChange = { checked = it }, label = "Accept settings")
            }
        }
        CouiCard {
            CouiSection(title = "Content and actions") {
                CouiListItem(
                    title = "Interactive list item",
                    subtitle = "Tap the row or the trailing icon",
                    leadingContent = { Text("•", style = MaterialTheme.typography.titleLarge) },
                    trailingContent = {
                        CouiIconButton(onClick = {}) {
                            Icon(CouiIcons.Add, contentDescription = "Add")
                        }
                    },
                    onClick = {},
                )
                CouiButtonGroup(modifier = Modifier.padding(16.dp)) {
                    CouiButton(text = "Primary action", onClick = {})
                    CouiButton(text = "Disabled action", onClick = {}, enabled = false)
                }
            }
        }
        CouiCard {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                CouiSegmentedButton(
                    segments = listOf(CouiSegment("Primary"), CouiSegment("Secondary")),
                    selectedIndex = segment,
                    onSelectedIndexChange = { segment = it },
                    enabled = enabled,
                )
                CouiSlider(value = slider, onValueChange = { slider = it }, enabled = enabled)
                CouiStepper(value = stepper, onValueChange = { stepper = it }, valueRange = 0..10, enabled = enabled)
                CouiRadioButton(selected = selected == 0, onClick = { selected = 0 }, label = "Default")
                CouiRadioButton(selected = selected == 1, onClick = { selected = 1 }, label = "Alternative")
            }
        }
    }
}

@Composable
fun PickersScreen() {
    var date by remember { mutableStateOf(CouiDate(2026, 1, 15)) }
    var year by remember { mutableStateOf(2026) }
    var month by remember { mutableStateOf(1) }
    var time by remember { mutableStateOf(CouiTime(12, 30)) }
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ExamplePageHeader("Pickers", "Calendar and time selection patterns")
        CouiCard {
            CouiDatePicker(
                selectedDate = date,
                onDateSelected = { date = it },
                displayedYear = year,
                displayedMonth = month,
                onDisplayedMonthChange = { nextYear, nextMonth -> year = nextYear; month = nextMonth },
                today = CouiDate(2026, 1, 15),
            )
        }
        CouiCard { CouiTimePicker(selectedTime = time, onTimeSelected = { time = it }, minuteStep = 5) }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoreScreen() {
    var tab by remember { mutableStateOf(0) }
    var menuExpanded by remember { mutableStateOf(false) }
    var menuItem by remember { mutableStateOf(0) }
    var chip by remember { mutableStateOf(0) }
    var refreshing by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(0.4f) }
    val animatedProgress by animateFloatAsState(progress, label = "example-progress")
    val refreshScope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ExamplePageHeader("More components", "Patterns for content, status, and gestures")
        CouiCard {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                CouiTabLayout(
                    items = listOf(CouiTabItem("Overview"), CouiTabItem("Details"), CouiTabItem("Style")),
                    selectedIndex = tab,
                    onSelectedIndexChange = { tab = it },
                )
                CouiDivider()
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    CouiChip(label = "Selected", selected = chip == 0, onClick = { chip = 0 })
                    CouiChip(label = "Filter", selected = chip == 1, onClick = { chip = 1 })
                    CouiBadge(label = "3")
                }
                CouiTooltip(message = "Long press to show tooltip") {
                    CouiButton(text = "Tooltip target", onClick = {})
                }
            }
        }
        CouiCard {
            CouiPreferenceCategory(title = "Preferences") {
                CouiPreferenceItem(
                    title = "Selected option",
                    summary = listOf("Blue", "Teal", "Neutral")[menuItem],
                    onClick = { menuExpanded = true },
                )
                CouiDropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = { menuExpanded = false },
                    items = listOf("Blue", "Teal", "Neutral"),
                    onItemSelected = { menuItem = it },
                )
            }
        }
        CouiCard {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Progress", style = MaterialTheme.typography.titleMedium)
                CouiProgressIndicator(progress = animatedProgress)
                CouiButton(text = "Advance", onClick = { progress = (progress + 0.2f).coerceAtMost(1f) })
            }
        }
        CouiCard {
            CouiPager(modifier = Modifier.height(200.dp), pageCount = 3) { page ->
                CouiEmptyState(title = "Pager page ${page + 1}", description = "Swipe horizontally")
            }
        }
        CouiCard {
            CouiPullRefresh(
                refreshing = refreshing,
                onRefresh = {
                    if (!refreshing) {
                        refreshing = true
                        refreshScope.launch {
                            delay(900)
                            refreshing = false
                        }
                    }
                },
                modifier = Modifier.height(180.dp).padding(20.dp),
            ) {
                CouiEmptyState(title = "Pull to refresh", description = "Drag down on this card")
            }
        }
    }
}

@Composable
private fun ExamplePageHeader(title: String, description: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(title, style = MaterialTheme.typography.headlineSmall)
        Text(
            description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
