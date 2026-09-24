package me.hawthorne.coui.ui

import kotlin.test.Test
import kotlin.test.assertEquals

class CouiDateTimeTest {
    @Test
    fun monthLengthsHandleLeapYears() {
        assertEquals(29, couiDaysInMonth(2024, 2))
        assertEquals(28, couiDaysInMonth(2025, 2))
        assertEquals(30, couiDaysInMonth(2026, 4))
        assertEquals(31, couiDaysInMonth(2026, 1))
    }

    @Test
    fun firstWeekdayUsesMondayAsZero() {
        assertEquals(3, couiFirstWeekday(2026, 1))
        assertEquals(6, couiFirstWeekday(2026, 2))
    }

    @Test
    fun minuteIndexClampsAndAppliesStep() {
        assertEquals(0, couiMinuteIndex(0, 15))
        assertEquals(0, couiMinuteIndex(14, 15))
        assertEquals(1, couiMinuteIndex(29, 15))
        assertEquals(3, couiMinuteIndex(59, 15))
        assertEquals(0, couiMinuteIndex(-1, 15))
    }
}
