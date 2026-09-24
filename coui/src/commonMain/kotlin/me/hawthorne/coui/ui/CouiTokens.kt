package me.hawthorne.coui.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object CouiTokens {
    object Spacing {
        val XSmall = 4.dp
        val Small = 8.dp
        val Medium = 12.dp
        val Large = 16.dp
        val XLarge = 20.dp
        val XXLarge = 24.dp
    }

    object Corners {
        val Small = 12.dp
        val Medium = 16.dp
        val Large = 20.dp
        val Pill = 999.dp
    }

    object Elevation {
        val Card = 1.dp
        val Navigation = 3.dp
        val TopBar = 2.dp
    }

    object Motion {
        const val Fast = 150
        const val Standard = 250
        const val Emphasized = 350
    }

    private val SmallCorner: Dp = 8.dp

    val Shapes = Shapes(
        extraSmall = RoundedCornerShape(SmallCorner),
        small = RoundedCornerShape(Corners.Small),
        medium = RoundedCornerShape(Corners.Medium),
        large = RoundedCornerShape(Corners.Large),
        extraLarge = RoundedCornerShape(Corners.Large),
    )
}

internal val CouiShape = RoundedCornerShape(CouiTokens.Corners.Medium)
