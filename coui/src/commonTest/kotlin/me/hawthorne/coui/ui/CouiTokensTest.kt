package me.hawthorne.coui.ui

import kotlin.test.Test
import kotlin.test.assertEquals

class CouiTokensTest {
    @Test
    fun spacingTokensRemainStable() {
        assertEquals(4f, CouiTokens.Spacing.XSmall.value)
        assertEquals(12f, CouiTokens.Spacing.Medium.value)
        assertEquals(24f, CouiTokens.Spacing.XXLarge.value)
    }

    @Test
    fun componentTokensMatchExtractedResources() {
        assertEquals(58f, CouiTokens.Components.AlertDialogButtonHeight.value)
        assertEquals(48f, CouiTokens.Components.ButtonHeight.value)
        assertEquals(52f, CouiTokens.Components.TopBarHeight.value)
        assertEquals(64f, CouiTokens.Components.ListItemMinHeight.value)
        assertEquals(60f, CouiTokens.Components.ListItemNormalHeight.value)
        assertEquals(48f, CouiTokens.Components.SwitchPreferenceMinHeight.value)
        assertEquals(16f, CouiTokens.Components.RoundCornerXlRadius.value)
        assertEquals(1.1f, CouiTokens.Components.RoundCornerMWeight)
    }

    @Test
    fun vectorIconsExposeStableNames() {
        assertEquals("CouiHome", CouiIcons.Home.name)
        assertEquals("CouiTune", CouiIcons.Tune.name)
        assertEquals("CouiCalendar", CouiIcons.Calendar.name)
        assertEquals("CouiMore", CouiIcons.More.name)
        assertEquals("CouiAdd", CouiIcons.Add.name)
        assertEquals("CouiRefresh", CouiIcons.Refresh.name)
        assertEquals("CouiBack", CouiIcons.Back.name)
        assertEquals("CouiSearch", CouiIcons.Search.name)
        assertEquals("CouiClose", CouiIcons.Close.name)
        assertEquals("CouiCheck", CouiIcons.Check.name)
        assertEquals("CouiChevronRight", CouiIcons.ChevronRight.name)
        assertEquals("CouiInfo", CouiIcons.Info.name)
    }

    @Test
    fun motionDurationsAreOrdered() {
        assertEquals(true, CouiTokens.Motion.Fast < CouiTokens.Motion.Standard)
        assertEquals(true, CouiTokens.Motion.Standard < CouiTokens.Motion.Emphasized)
    }
}
