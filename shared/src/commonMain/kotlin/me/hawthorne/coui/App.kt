package me.hawthorne.coui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import me.hawthorne.coui.ui.CouiDialog
import me.hawthorne.coui.ui.CouiDivider
import me.hawthorne.coui.ui.CouiListItem
import me.hawthorne.coui.ui.CouiProgressIndicator
import me.hawthorne.coui.ui.CouiRadioButton
import me.hawthorne.coui.ui.CouiSection
import me.hawthorne.coui.ui.CouiSlider
import me.hawthorne.coui.ui.CouiSnackbarHost
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
        val snackbarHostState = remember { androidx.compose.material3.SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Column(modifier = Modifier.fillMaxSize()) {
            CouiTopBar(title = "COUI")
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    CouiCard {
                        Column(modifier = Modifier.padding(20.dp)) {
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
                    CouiSection(title = "Feedback") {
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
            }
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
