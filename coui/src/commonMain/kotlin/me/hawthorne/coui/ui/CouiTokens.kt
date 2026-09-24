package me.hawthorne.coui.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Color
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
        val AlertDialog = 22.dp
        val Pill = 999.dp
    }

    object Elevation {
        val Card = 2.dp
        val Navigation = 4.dp
        val TopBar = 3.dp
    }

    object Components {
        val AlertDialogButtonHeight = 58.dp
        val AlertDialogMaxWidth = 400.dp
        val AlertDialogMaxHeight = 470.dp
        val AlertDialogButtonPanelPaddingTop = 14.dp
        val DialogContentMinHeight = 66.dp
        val DialogHorizontalPadding = 24.dp
        val DialogTitleMinHeight = 22.dp
        val ButtonHeight = 48.dp
        val TopBarHeight = 56.dp
        val ListItemMinHeight = 64.dp
        val FloatingPopupMinWidth = 56.dp
        val FloatingPopupMinHeight = 44.dp
        val FloatingPopupIconSize = 20.dp
        val RoundCornerXlRadius = 16.dp
        const val RoundCornerMWeight = 1.1f
        const val RoundCornerXlWeight = 0.99f
    }

    object Popup {
        val DarkBlendBlur = Color(0xFF4D4D4D)
        val DarkMixBlur = Color(0xCCB2B2B2)
        val LightBlendBlur = Color(0xFF737373)
        val LightMixBlur = Color(0xCC404040)
        val BackgroundAboveBlur = Color.Transparent
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
