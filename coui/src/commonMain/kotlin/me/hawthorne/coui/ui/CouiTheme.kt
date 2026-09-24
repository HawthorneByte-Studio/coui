package me.hawthorne.coui.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

private val LightColors = lightColorScheme(
    primary = CouiColors.Blue,
    onPrimary = Color.White,
    primaryContainer = CouiColors.BlueContainer,
    onPrimaryContainer = CouiColors.BlueOnContainer,
    secondary = CouiColors.Teal,
    background = CouiColors.LightBackground,
    surface = CouiColors.LightSurface,
    surfaceVariant = CouiColors.LightSurfaceVariant,
)

private val DarkColors = darkColorScheme(
    primary = CouiColors.BlueLight,
    onPrimary = CouiColors.BlueDark,
    primaryContainer = CouiColors.BlueDark,
    onPrimaryContainer = CouiColors.BlueLight,
    secondary = CouiColors.TealLight,
    background = CouiColors.DarkBackground,
    surface = CouiColors.DarkSurface,
    surfaceVariant = CouiColors.DarkSurfaceVariant,
)

object CouiColors {
    val Blue = Color(0xFF2A74FF)
    val BlueLight = Color(0xFF9DBBFF)
    val BlueDark = Color(0xFF123B86)
    val BlueContainer = Color(0xFFDCE7FF)
    val BlueOnContainer = Color(0xFF001A41)
    val Teal = Color(0xFF008A8A)
    val TealLight = Color(0xFF55DADA)
    val LightBackground = Color(0xFFF5F6F8)
    val LightSurface = Color.White
    val LightSurfaceVariant = Color(0xFFEEF0F4)
    val DarkBackground = Color(0xFF111214)
    val DarkSurface = Color(0xFF1C1D20)
    val DarkSurfaceVariant = Color(0xFF2A2C30)
}

private val CouiTypography = Typography().copy(
    titleLarge = Typography().titleLarge.copy(fontWeight = FontWeight.SemiBold),
    titleMedium = Typography().titleMedium.copy(fontWeight = FontWeight.SemiBold),
    headlineSmall = Typography().headlineSmall.copy(fontWeight = FontWeight.SemiBold),
)

@Composable
fun CouiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorScheme: ColorScheme = if (darkTheme) DarkColors else LightColors,
    typography: Typography = CouiTypography,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        shapes = CouiTokens.Shapes,
        content = content,
    )
}
