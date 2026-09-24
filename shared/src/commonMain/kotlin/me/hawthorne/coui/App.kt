package me.hawthorne.coui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.hawthorne.coui.ui.CouiButton
import me.hawthorne.coui.ui.CouiBottomSheet
import me.hawthorne.coui.ui.CouiCard
import me.hawthorne.coui.ui.CouiCheckbox
import me.hawthorne.coui.ui.CouiChip
import me.hawthorne.coui.ui.CouiDialog
import me.hawthorne.coui.ui.CouiDivider
import me.hawthorne.coui.ui.CouiEmptyState
import me.hawthorne.coui.ui.CouiIconButton
import me.hawthorne.coui.ui.CouiListItem
import me.hawthorne.coui.ui.CouiNavigationBar
import me.hawthorne.coui.ui.CouiNavigationItem
import me.hawthorne.coui.ui.CouiProgressIndicator
import me.hawthorne.coui.ui.CouiPreferenceCategory
import me.hawthorne.coui.ui.CouiPreferenceItem
import me.hawthorne.coui.ui.CouiRadioButton
import me.hawthorne.coui.ui.CouiSearchField
import me.hawthorne.coui.ui.CouiTabItem
import me.hawthorne.coui.ui.CouiTabLayout
import me.hawthorne.coui.ui.CouiDropdownMenu
import me.hawthorne.coui.ui.CouiSection
import me.hawthorne.coui.ui.CouiSlider
import me.hawthorne.coui.ui.CouiSnackbarHost
import me.hawthorne.coui.ui.CouiSegment
import me.hawthorne.coui.ui.CouiSegmentedButton
import me.hawthorne.coui.ui.CouiStepper
import me.hawthorne.coui.ui.CouiInfoBanner
import me.hawthorne.coui.ui.CouiSwitch
import me.hawthorne.coui.ui.CouiTextField
import me.hawthorne.coui.ui.CouiTheme
import me.hawthorne.coui.ui.CouiTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    CouiTheme {
        var enabled by remember { mutableStateOf(true) }
        var text by remember { mutableStateOf("") }
        var dialogVisible by remember { mutableStateOf(false) }
        var sheetVisible by remember { mutableStateOf(false) }
        var progress by remember { mutableStateOf(0.6f) }
        var sliderValue by remember { mutableStateOf(0.5f) }
        var selectedOption by remember { mutableStateOf(0) }
        var query by remember { mutableStateOf("") }
        var selectedTab by remember { mutableStateOf(0) }
        var selectedSection by remember { mutableStateOf(0) }
        var checked by remember { mutableStateOf(false) }
        var menuExpanded by remember { mutableStateOf(false) }
        var selectedMenuItem by remember { mutableStateOf(0) }
        var stepperValue by remember { mutableStateOf(2) }
        var selectedChip by remember { mutableStateOf(0) }
        var selectedSegment by remember { mutableStateOf(0) }
        val snackbarHostState = remember { androidx.compose.material3.SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Column(modifier = Modifier.fillMaxSize()) {
            CouiTopBar(title = "COUI")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    CouiCard {
                        Column(modifier = Modifier.padding(20.dp)) {
                            CouiSearchField(
                                query = query,
                                onQueryChange = { query = it },
                                placeholder = "Search components",
                                trailingContent = {
                                    CouiIconButton(onClick = { query = "" }, enabled = query.isNotEmpty()) {
                                        Text("Clear")
                                    }
                                },
                            )
                        }
                    }
                }
                item {
                    CouiCard {
                        Column(modifier = Modifier.padding(20.dp)) {
                            CouiTabLayout(
                                items = listOf(
                                    CouiTabItem("Overview"),
                                    CouiTabItem("Details"),
                                    CouiTabItem("Style"),
                                ),
                                selectedIndex = selectedSection,
                                onSelectedIndexChange = { selectedSection = it },
                            )
                            CouiDivider(modifier = Modifier.padding(vertical = 8.dp))
                            Text("ColorOS UI foundation")
                            Text(
                                text = "A Compose Multiplatform starting point for COUI components.",
                                modifier = Modifier.padding(top = 8.dp),
                            )
                        }
                    }
                }
                item {
                    CouiCard {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text("Controls")
                            CouiSwitch(
                                checked = enabled,
                                onCheckedChange = { enabled = it },
                                label = "Enable COUI theme",
                                modifier = Modifier.padding(top = 12.dp),
                            )
                            CouiCheckbox(
                                checked = checked,
                                onCheckedChange = { checked = it },
                                label = "Enable component preview",
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                listOf("Blue", "Teal", "Neutral").forEachIndexed { index, label ->
                                    CouiChip(
                                        label = label,
                                        selected = selectedChip == index,
                                        onClick = { selectedChip = index },
                                    )
                                }
                            }
                            CouiStepper(
                                value = stepperValue,
                                onValueChange = { stepperValue = it },
                                valueRange = 0..10,
                            )
                            CouiSegmentedButton(
                                segments = listOf(
                                    CouiSegment("List"),
                                    CouiSegment("Grid"),
                                ),
                                selectedIndex = selectedSegment,
                                onSelectedIndexChange = { selectedSegment = it },
                            )
                            CouiButton(
                                text = "Choose style: ${listOf("Blue", "Teal", "Neutral")[selectedMenuItem]}",
                                onClick = { menuExpanded = true },
                            )
                            CouiDropdownMenu(
                                expanded = menuExpanded,
                                onDismissRequest = { menuExpanded = false },
                                items = listOf("Blue", "Teal", "Neutral"),
                                onItemSelected = { selectedMenuItem = it },
                            )
                        }
                    }
                }
                item {
                    CouiCard {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            Text("Actions")
                            CouiTextField(
                                value = text,
                                onValueChange = { text = it },
                                label = "Name",
                                placeholder = "Enter a value",
                            )
                            CouiButton(text = "Primary action", onClick = {}, enabled = enabled)
                            CouiButton(text = "Show dialog", onClick = { dialogVisible = true })
                            CouiButton(text = "Show bottom sheet", onClick = { sheetVisible = true })
                            CouiButton(
                                text = "Show snackbar",
                                onClick = { scope.launch { snackbarHostState.showSnackbar("Action completed") } },
                            )
                        }
                    }
                }
                item {
                    CouiCard {
                        CouiListItem(
                            title = "Component list item",
                            subtitle = "Reusable title and subtitle layout",
                            onClick = {},
                        )
                    }
                }
                item {
                    CouiCard {
                        CouiEmptyState(
                            title = "No more components",
                            description = "The next COUI controls will appear here.",
                            actionText = "Refresh",
                        )
                    }
                }
                item {
                    CouiSection(title = "Feedback") {
                        CouiInfoBanner(
                            title = "COUI foundation",
                            message = "These components are ready to reuse across screens.",
                            actionText = "Dismiss",
                        )
                        CouiCard {
                            Column(modifier = Modifier.padding(20.dp)) {
                                Text("Loading progress")
                                CouiProgressIndicator(
                                    progress = progress,
                                    modifier = Modifier.padding(top = 12.dp),
                                )
                                CouiDivider(modifier = Modifier.padding(vertical = 16.dp))
                                CouiButton(
                                    text = "Advance",
                                    onClick = { progress = (progress + 0.1f).coerceAtMost(1f) },
                                )
                                Text("Slider: ${(sliderValue * 100).toInt()}%")
                                CouiSlider(
                                    value = sliderValue,
                                    onValueChange = { sliderValue = it },
                                )
                                CouiRadioButton(
                                    selected = selectedOption == 0,
                                    onClick = { selectedOption = 0 },
                                    label = "Default option",
                                )
                                CouiRadioButton(
                                    selected = selectedOption == 1,
                                    onClick = { selectedOption = 1 },
                                    label = "Alternative option",
                                )
                            }
                        }
                    }
                }
                item {
                    CouiCard {
                        CouiPreferenceCategory(title = "Preferences") {
                            CouiPreferenceItem(
                                title = "Component preview",
                                summary = "Show the latest COUI controls in the sample screen",
                                trailingContent = {
                                    CouiSwitch(
                                        checked = checked,
                                        onCheckedChange = { checked = it },
                                        label = "",
                                    )
                                },
                            )
                            CouiDivider()
                            CouiPreferenceItem(
                                title = "Selected style",
                                summary = listOf("Blue", "Teal", "Neutral")[selectedMenuItem],
                                onClick = { menuExpanded = true },
                            )
                        }
                    }
                }
            }
            CouiNavigationBar(
                items = listOf(
                    CouiNavigationItem(
                        label = "Home",
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                    ),
                    CouiNavigationItem(
                        label = "Components",
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        badge = "3",
                    ),
                    CouiNavigationItem(
                        label = "Settings",
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                    ),
                ),
            )
        }
        if (dialogVisible) {
            CouiDialog(
                title = "COUI dialog",
                message = "This dialog is built from the COUI overlay API.",
                onDismissRequest = { dialogVisible = false },
                onConfirm = { dialogVisible = false },
            )
        }
        if (sheetVisible) {
            CouiBottomSheet(
                onDismissRequest = { sheetVisible = false },
            ) {
                Text("COUI bottom sheet", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)
                Text(
                    text = "Use this slot for actions or supporting content.",
                    modifier = Modifier.padding(top = 8.dp),
                )
                CouiButton(
                    text = "Close",
                    onClick = { sheetVisible = false },
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
        }
        CouiSnackbarHost(
            modifier = Modifier.padding(bottom = 16.dp),
            hostState = snackbarHostState,
        )
    }
}
