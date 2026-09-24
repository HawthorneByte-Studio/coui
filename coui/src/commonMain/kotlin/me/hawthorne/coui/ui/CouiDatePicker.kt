package me.hawthorne.coui.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

data class CouiDate(
    val year: Int,
    val month: Int,
    val day: Int,
)

private val CouiMonthNames = listOf(
    "January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December",
)

@Composable
fun CouiDatePicker(
    selectedDate: CouiDate?,
    onDateSelected: (CouiDate) -> Unit,
    modifier: Modifier = Modifier,
    displayedYear: Int = selectedDate?.year ?: 2026,
    displayedMonth: Int = selectedDate?.month ?: 1,
    onDisplayedMonthChange: (year: Int, month: Int) -> Unit = { _, _ -> },
) {
    val safeMonth = displayedMonth.coerceIn(1, 12)
    Column(modifier = modifier.fillMaxWidth().padding(CouiTokens.Spacing.Large)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CouiButton(
                text = "Prev",
                onClick = {
                    val previousMonth = if (safeMonth == 1) 12 else safeMonth - 1
                    val previousYear = if (safeMonth == 1) displayedYear - 1 else displayedYear
                    onDisplayedMonthChange(previousYear, previousMonth)
                },
            )
            Text(
                text = "${CouiMonthNames[safeMonth - 1]} $displayedYear",
                style = MaterialTheme.typography.titleMedium,
            )
            CouiButton(
                text = "Next",
                onClick = {
                    val nextMonth = if (safeMonth == 12) 1 else safeMonth + 1
                    val nextYear = if (safeMonth == 12) displayedYear + 1 else displayedYear
                    onDisplayedMonthChange(nextYear, nextMonth)
                },
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = CouiTokens.Spacing.Large),
        ) {
            listOf("M", "T", "W", "T", "F", "S", "S").forEach { label ->
                Text(
                    text = label,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
        val leadingEmptyDays = firstWeekday(displayedYear, safeMonth)
        val totalDays = daysInMonth(displayedYear, safeMonth)
        val cells = List(leadingEmptyDays) { null } + (1..totalDays).map { it }
        cells.chunked(7).forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { day ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = CouiTokens.Spacing.XSmall),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (day != null) {
                            val date = CouiDate(displayedYear, safeMonth, day)
                            val selected = date == selectedDate
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .then(
                                        if (selected) {
                                            Modifier.background(MaterialTheme.colorScheme.primary, CircleShape)
                                        } else {
                                            Modifier
                                        },
                                    )
                                    .clickable { onDateSelected(date) },
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = day.toString(),
                                    color = if (selected) {
                                        MaterialTheme.colorScheme.onPrimary
                                    } else {
                                        MaterialTheme.colorScheme.onSurface
                                    },
                                    style = MaterialTheme.typography.bodyMedium,
                                )
                            }
                        }
                    }
                }
                repeat(7 - week.size) {
                    Box(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

private fun daysInMonth(year: Int, month: Int): Int = when (month) {
    2 -> if (isLeapYear(year)) 29 else 28
    4, 6, 9, 11 -> 30
    else -> 31
}

private fun isLeapYear(year: Int): Boolean = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)

private fun firstWeekday(year: Int, month: Int): Int {
    var adjustedYear = year
    var adjustedMonth = month
    if (adjustedMonth < 3) {
        adjustedMonth += 12
        adjustedYear -= 1
    }
    val century = adjustedYear / 100
    val yearOfCentury = adjustedYear % 100
    val sundayBased = (1 + (13 * (adjustedMonth + 1)) / 5 + yearOfCentury + yearOfCentury / 4 + century / 4 + 5 * century) % 7
    return (sundayBased + 5) % 7
}
