package me.hawthorne.coui.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun CouiButtonsPreview() {
    CouiTheme {
        CouiButtonGroup {
            CouiButton(text = "Primary", onClick = {})
            CouiButton(text = "Disabled", onClick = {}, enabled = false)
        }
    }
}

@Preview
@Composable
private fun CouiSelectionPreview() {
    CouiTheme {
        CouiSegmentedButton(
            segments = listOf(CouiSegment("First"), CouiSegment("Second")),
            selectedIndex = 0,
            onSelectedIndexChange = {},
        )
    }
}

@Preview
@Composable
private fun CouiDateTimePreview() {
    CouiTheme {
        CouiDatePicker(
            selectedDate = CouiDate(2026, 1, 15),
            onDateSelected = {},
        )
    }
}

@Preview
@Composable
private fun CouiPreferencePreview() {
    CouiTheme {
        CouiPreferenceCategory(title = "Preferences") {
            CouiPreferenceItem(
                title = "Theme",
                summary = "Use the system theme",
                onClick = {},
            )
        }
    }
}
