package me.hawthorne.coui.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        val TopBarHeight = 52.dp
        val TopBarTitleSize = 24.sp
        val TopBarTitlePaddingStart = 24.dp
        val SearchFieldHeight = 40.dp
        val SearchFieldTextSize = 15.sp
        val SearchFieldHintSize = 12.sp
        val SearchFieldIconMargin = 12.dp
        val ListItemMinHeight = 64.dp
        val FloatingPopupMinWidth = 56.dp
        val FloatingPopupMinHeight = 44.dp
        val FloatingPopupIconSize = 20.dp
        val PopupListMinWidth = 132.dp
        val PopupListMaxWidth = 328.dp
        val PopupListContentRadius = 16.dp
        val PopupListItemMinHeight = 42.dp
        val PopupListItemVerticalPadding = 8.dp
        val PopupListItemHorizontalPadding = 24.dp
        val PreferenceItemMinHeight = 48.dp
        val PreferenceHorizontalPadding = 32.dp
        val PreferenceContentSpacing = 16.dp
        val SwitchPreferenceMinHeight = 48.dp
        val ListItemNormalHeight = 60.dp
        val ListItemHorizontalPadding = 16.dp
        val PreferenceIconVerticalMargin = 14.dp
        val PreferenceIconEndMargin = 16.dp
        val NavigationBarHeight = 56.dp
        val NavigationItemHeight = 48.dp
        val NavigationItemIconTopMargin = 4.dp
        val NavigationItemIconLabelGap = 2.dp
        val NavigationItemSpacing = 8.dp
        val NavigationBarHorizontalPadding = 16.dp
        val NavigationItemMaxWidth = 70.dp
        val ChipMinHeight = 32.dp
        val ChipHorizontalPadding = 12.dp
        val ChipGroupSpacing = 8.dp
        val BottomSheetTopCornerRadius = 22.dp
        val BottomSheetContentHorizontalPadding = 16.dp
        val BottomSheetTopMargin = 40.dp
        val BottomSheetElevation = 17.dp
        val TooltipCornerRadius = 17.dp
        val TooltipPadding = 13.dp
        val TooltipFloatingHorizontalPadding = 16.dp
        val ProgressIndicatorHeight = 4.dp
        val CircularProgressLength = 40.dp
        val CircularProgressStrokeWidth = 5.dp
        val DatePickerDaySize = 40.dp
        val DatePickerWeekdayHeight = 32.dp
        val DatePickerHorizontalPadding = 16.dp
        val TimePickerFocusTextHeight = 48.dp
        val TimePickerNormalTextHeight = 40.dp
        val TimePickerHeight = 240.dp
        val TabLayoutHeight = 48.dp
        val TabIndicatorHeight = 2.dp
        val TabHorizontalPadding = 16.dp
        val PagerIndicatorSelectedSize = 8.dp
        val PagerIndicatorSize = 6.dp
        val PagerIndicatorSpacing = 4.dp
        val SliderProgressHeight = 20.dp
        val SliderThumbRadius = 6.dp
        val SnackbarMaxWidth = 328.dp
        val SnackbarPaddingVertical = 16.dp
        val SnackbarRadius = 16.dp
        val SnackbarSingleLineRadius = 24.dp
        val SnackbarMarginBottom = 32.dp
        val RoundCornerXlRadius = 16.dp
        const val RoundCornerMWeight = 1.1f
        const val RoundCornerXlWeight = 0.99f
    }

    object Popup {
        val DarkBlendBlur = Color(0xFF4D4D4D)
        val DarkMixBlur = Color(0xCCB2B2B2)
        val LightBlendBlur = Color(0xFF737373)
        val LightMixBlur = Color(0xCC404040)
        val LightBackground = Color(0xFFFFFFFF)
        val DarkBackground = Color(0xFF242424)
        val LightPressed = Color(0x08000000)
        val DarkPressed = Color(0x14000000)
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
