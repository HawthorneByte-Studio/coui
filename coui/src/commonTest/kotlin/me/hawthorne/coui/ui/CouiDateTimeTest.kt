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

    @Test
    fun datesCompareChronologically() {
        assertEquals(true, CouiDate(2026, 1, 2) > CouiDate(2026, 1, 1))
        assertEquals(true, CouiDate(2026, 2, 1) > CouiDate(2026, 1, 31))
        assertEquals(true, CouiDate(2025, 12, 31) < CouiDate(2026, 1, 1))
    }

    @Test
    fun dateAndTimeModelsRejectInvalidValues() {
        assertFailsWith<IllegalArgumentException> { CouiDate(2026, 13, 1) }
        assertFailsWith<IllegalArgumentException> { CouiDate(2026, 2, 30) }
        assertFailsWith<IllegalArgumentException> { CouiTime(24, 0) }
        assertFailsWith<IllegalArgumentException> { CouiTime(12, 60) }
    }

    @Test
    fun timeFormattingSupports24And12HourModes() {
        assertEquals("00:05", couiFormatTime(CouiTime(0, 5)))
        assertEquals("12:05 AM", couiFormatTime(CouiTime(0, 5, is24Hour = false)))
        assertEquals("12:05 PM", couiFormatTime(CouiTime(12, 5, is24Hour = false)))
        assertEquals("11:05 PM", couiFormatTime(CouiTime(23, 5, is24Hour = false)))
    }

    @Test
    fun timeHourConversionPreservesPeriod() {
        assertEquals(13, couiNormalizeHour(1, is24Hour = false, isPm = true))
        assertEquals(1, couiNormalizeHour(1, is24Hour = false, isPm = false))
        assertEquals(23, couiNormalizeHour(23, is24Hour = true, isPm = true))
        assertEquals(12, couiDisplayHour(CouiTime(0, 0, is24Hour = false)))
        assertEquals(12, couiDisplayHour(CouiTime(12, 0, is24Hour = false)))
    }

    @Test
    fun minuteValueMapsStepperIndexToConfiguredStep() {
        assertEquals(0, couiMinuteValue(0, 15))
        assertEquals(15, couiMinuteValue(1, 15))
        assertEquals(45, couiMinuteValue(3, 15))
        assertEquals(59, couiMinuteValue(99, 15))
    }
}
