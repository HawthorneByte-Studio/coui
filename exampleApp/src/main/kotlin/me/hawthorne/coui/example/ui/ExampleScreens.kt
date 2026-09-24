package me.hawthorne.coui.example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.hawthorne.coui.ui.CouiButton
import me.hawthorne.coui.ui.CouiCard
import me.hawthorne.coui.ui.CouiCheckbox
import me.hawthorne.coui.ui.CouiDate
import me.hawthorne.coui.ui.CouiDatePicker
import me.hawthorne.coui.ui.CouiEmptyState
import me.hawthorne.coui.ui.CouiInfoBanner
import me.hawthorne.coui.ui.CouiRadioButton
import me.hawthorne.coui.ui.CouiSearchField
import me.hawthorne.coui.ui.CouiSegment
import me.hawthorne.coui.ui.CouiSegmentedButton
import me.hawthorne.coui.ui.CouiSlider
import me.hawthorne.coui.ui.CouiStepper
import me.hawthorne.coui.ui.CouiSwitch
import me.hawthorne.coui.ui.CouiTextField
import me.hawthorne.coui.ui.CouiTime
import me.hawthorne.coui.ui.CouiTimePicker

@Composable
fun HomeScreen(onDialog: () -> Unit, onSheet: () -> Unit, onSnackbar: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
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
        CouiCard {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                CouiSearchField(query = query, onQueryChange = { query = it }, placeholder = "Search components")
                CouiTextField(value = text, onValueChange = { text = it }, label = "Text field")
                CouiSwitch(checked = enabled, onCheckedChange = { enabled = it }, label = "Enabled controls")
                CouiCheckbox(checked = checked, onCheckedChange = { checked = it }, label = "Accept settings")
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
