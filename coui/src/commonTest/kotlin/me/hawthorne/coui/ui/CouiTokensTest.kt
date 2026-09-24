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
        assertEquals(16f, CouiTokens.Components.RoundCornerXlRadius.value)
        assertEquals(1.1f, CouiTokens.Components.RoundCornerMWeight)
    }

    @Test
    fun motionDurationsAreOrdered() {
        assertEquals(true, CouiTokens.Motion.Fast < CouiTokens.Motion.Standard)
        assertEquals(true, CouiTokens.Motion.Standard < CouiTokens.Motion.Emphasized)
    }
}
