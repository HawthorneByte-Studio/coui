package me.hawthorne.coui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class CouiTime(
    val hour: Int,
    val minute: Int,
    val is24Hour: Boolean = true,
)
{
    init {
        require(hour in 0..23)
        require(minute in 0..59)
    }
}

@Composable
fun CouiTimePicker(
    selectedTime: CouiTime,
    onTimeSelected: (CouiTime) -> Unit,
    modifier: Modifier = Modifier,
    minuteStep: Int = 1,
) {
    val safeStep = minuteStep.coerceIn(1, 30)
    val maxHour = if (selectedTime.is24Hour) 23 else 12
    val minHour = if (selectedTime.is24Hour) 0 else 1
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(CouiTokens.Spacing.Large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(CouiTokens.Spacing.Medium),
    ) {
        Text(
            text = couiFormatTime(selectedTime),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(CouiTokens.Spacing.Small),
        ) {
            CouiStepper(
                value = couiDisplayHour(selectedTime),
                onValueChange = { hour ->
                    onTimeSelected(
                        selectedTime.copy(
                            hour = couiNormalizeHour(
                                hour = hour,
                                is24Hour = selectedTime.is24Hour,
                                isPm = selectedTime.hour >= 12,
                            ),
                        ),
                    )
                },
                valueRange = minHour..maxHour,
            )
            Text(":", style = MaterialTheme.typography.headlineMedium)
            CouiStepper(
                value = couiMinuteIndex(selectedTime.minute, safeStep),
                onValueChange = { minuteIndex ->
                    onTimeSelected(
                        selectedTime.copy(
                            minute = couiMinuteValue(minuteIndex, safeStep),
                        ),
                    )
                },
                valueRange = 0..(59 / safeStep),
            )
        }
        CouiSegmentedButton(
            segments = listOf(CouiSegment("24-hour"), CouiSegment("12-hour")),
            selectedIndex = if (selectedTime.is24Hour) 0 else 1,
            onSelectedIndexChange = { mode ->
                val use24Hour = mode == 0
                if (use24Hour != selectedTime.is24Hour) {
                    onTimeSelected(selectedTime.copy(is24Hour = use24Hour))
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )
        if (!selectedTime.is24Hour) {
            CouiSegmentedButton(
                segments = listOf(CouiSegment("AM"), CouiSegment("PM")),
                selectedIndex = if (selectedTime.hour >= 12) 1 else 0,
                onSelectedIndexChange = { period ->
                    val currentIsPm = selectedTime.hour >= 12
                    if (currentIsPm != (period == 1)) {
                        onTimeSelected(selectedTime.copy(hour = (selectedTime.hour + 12) % 24))
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Text(
            text = "Minute step: $safeStep - values snap to ${safeStep}-minute intervals",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

internal fun couiDisplayHour(time: CouiTime): Int {
    if (time.is24Hour) return time.hour.coerceIn(0, 23)
    return when (val hour = time.hour % 12) {
        0 -> 12
        else -> hour
    }
}

internal fun couiNormalizeHour(hour: Int, is24Hour: Boolean, isPm: Boolean): Int {
    if (is24Hour) return hour.coerceIn(0, 23)
    val normalized = hour.coerceIn(1, 12) % 12
    return if (isPm) normalized + 12 else normalized
}

internal fun couiFormatTime(time: CouiTime): String {
    val hour = if (time.is24Hour) time.hour else couiDisplayHour(time)
    val period = if (!time.is24Hour) if (time.hour >= 12) " PM" else " AM" else ""
    return "%02d:%02d%s".format(hour, time.minute, period)
}

internal fun couiMinuteIndex(minute: Int, step: Int): Int =
    minute.coerceIn(0, 59) / step

internal fun couiMinuteValue(index: Int, step: Int): Int =
    (index.coerceAtLeast(0) * step.coerceIn(1, 30)).coerceIn(0, 59)
