package me.hawthorne.coui.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object CouiIcons {
    val Home: ImageVector by lazy {
        ImageVector.Builder("CouiHome", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(12f, 3f)
                lineTo(3f, 10f)
                verticalLineTo(21f)
                horizontalLineTo(9f)
                verticalLineTo(14f)
                horizontalLineTo(15f)
                verticalLineTo(21f)
                horizontalLineTo(21f)
                verticalLineTo(10f)
                close()
            }
        }.build()
    }

    val Tune: ImageVector by lazy {
        ImageVector.Builder("CouiTune", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(4f, 7f)
                horizontalLineTo(20f)
                verticalLineTo(9f)
                horizontalLineTo(4f)
                close()
                moveTo(4f, 11f)
                horizontalLineTo(20f)
                verticalLineTo(13f)
                horizontalLineTo(4f)
                close()
                moveTo(4f, 15f)
                horizontalLineTo(20f)
                verticalLineTo(17f)
                horizontalLineTo(4f)
                close()
                moveTo(8f, 5f)
                horizontalLineTo(10f)
                verticalLineTo(11f)
                horizontalLineTo(8f)
                close()
                moveTo(14f, 9f)
                horizontalLineTo(16f)
                verticalLineTo(15f)
                horizontalLineTo(14f)
                close()
                moveTo(6f, 13f)
                horizontalLineTo(8f)
                verticalLineTo(19f)
                horizontalLineTo(6f)
                close()
            }
        }.build()
    }

    val Calendar: ImageVector by lazy {
        ImageVector.Builder("CouiCalendar", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(5f, 4f)
                horizontalLineTo(7f)
                verticalLineTo(7f)
                horizontalLineTo(17f)
                verticalLineTo(4f)
                horizontalLineTo(19f)
                verticalLineTo(7f)
                horizontalLineTo(21f)
                verticalLineTo(20f)
                horizontalLineTo(3f)
                verticalLineTo(7f)
                horizontalLineTo(5f)
                close()
                moveTo(5f, 9f)
                verticalLineTo(18f)
                horizontalLineTo(19f)
                verticalLineTo(9f)
                close()
            }
        }.build()
    }

    val More: ImageVector by lazy {
        ImageVector.Builder("CouiMore", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(5f, 10f)
                horizontalLineTo(8f)
                verticalLineTo(13f)
                horizontalLineTo(5f)
                close()
                moveTo(10.5f, 10f)
                horizontalLineTo(13.5f)
                verticalLineTo(13f)
                horizontalLineTo(10.5f)
                close()
                moveTo(16f, 10f)
                horizontalLineTo(19f)
                verticalLineTo(13f)
                horizontalLineTo(16f)
                close()
            }
        }.build()
    }

    val Add: ImageVector by lazy {
        ImageVector.Builder("CouiAdd", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(11f, 4f)
                horizontalLineTo(13f)
                verticalLineTo(11f)
                horizontalLineTo(20f)
                verticalLineTo(13f)
                horizontalLineTo(13f)
                verticalLineTo(20f)
                horizontalLineTo(11f)
                verticalLineTo(13f)
                horizontalLineTo(4f)
                verticalLineTo(11f)
                horizontalLineTo(11f)
                close()
            }
        }.build()
    }

    val Refresh: ImageVector by lazy {
        ImageVector.Builder("CouiRefresh", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(17.65f, 6.35f)
                curveTo(16.2f, 4.9f, 14.21f, 4f, 12f, 4f)
                curveTo(7.58f, 4f, 4f, 7.58f, 4f, 12f)
                horizontalLineTo(7f)
                curveTo(7f, 9.24f, 9.24f, 7f, 12f, 7f)
                curveTo(13.66f, 7f, 15.14f, 7.67f, 16.22f, 8.78f)
                lineTo(14f, 11f)
                horizontalLineTo(20f)
                verticalLineTo(5f)
                close()
                moveTo(17f, 12f)
                curveTo(17f, 14.76f, 14.76f, 17f, 12f, 17f)
                curveTo(10.34f, 17f, 8.86f, 16.33f, 7.78f, 15.22f)
                lineTo(10f, 13f)
                horizontalLineTo(4f)
                verticalLineTo(19f)
                lineTo(6.35f, 16.65f)
                curveTo(7.8f, 18.1f, 9.79f, 19f, 12f, 19f)
                curveTo(16.42f, 19f, 20f, 15.42f, 20f, 11f)
                horizontalLineTo(17f)
                close()
            }
        }.build()
    }

    val Back: ImageVector by lazy {
        ImageVector.Builder("CouiBack", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(20f, 11f)
                horizontalLineTo(7.83f)
                lineTo(13.42f, 5.41f)
                lineTo(12f, 4f)
                lineTo(4f, 12f)
                lineTo(12f, 20f)
                lineTo(13.42f, 18.59f)
                lineTo(7.83f, 13f)
                horizontalLineTo(20f)
                close()
            }
        }.build()
    }

    val Search: ImageVector by lazy {
        ImageVector.Builder("CouiSearch", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(9.5f, 4f)
                curveTo(6.46f, 4f, 4f, 6.46f, 4f, 9.5f)
                curveTo(4f, 12.54f, 6.46f, 15f, 9.5f, 15f)
                curveTo(10.87f, 15f, 12.13f, 14.5f, 13.1f, 13.67f)
                lineTo(18.72f, 19.29f)
                lineTo(20.14f, 17.87f)
                lineTo(14.52f, 12.25f)
                curveTo(15.13f, 11.45f, 15.5f, 10.51f, 15.5f, 9.5f)
                curveTo(15.5f, 6.46f, 13.04f, 4f, 9.5f, 4f)
                close()
            }
        }.build()
    }

    val Close: ImageVector by lazy {
        ImageVector.Builder("CouiClose", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(6.41f, 5f)
                lineTo(12f, 10.59f)
                lineTo(17.59f, 5f)
                lineTo(19f, 6.41f)
                lineTo(13.41f, 12f)
                lineTo(19f, 17.59f)
                lineTo(17.59f, 19f)
                lineTo(12f, 13.41f)
                lineTo(6.41f, 19f)
                lineTo(5f, 17.59f)
                lineTo(10.59f, 12f)
                lineTo(5f, 6.41f)
                close()
            }
        }.build()
    }

    val Check: ImageVector by lazy {
        ImageVector.Builder("CouiCheck", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(9f, 16.17f)
                lineTo(4.83f, 12f)
                lineTo(3.41f, 13.41f)
                lineTo(9f, 19f)
                lineTo(21f, 7f)
                lineTo(19.59f, 5.59f)
                close()
            }
        }.build()
    }

    val ChevronRight: ImageVector by lazy {
        ImageVector.Builder("CouiChevronRight", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(9.29f, 6.71f)
                lineTo(14.59f, 12f)
                lineTo(9.29f, 17.29f)
                lineTo(10.71f, 18.71f)
                lineTo(17.41f, 12f)
                lineTo(10.71f, 5.29f)
                close()
            }
        }.build()
    }

    val Info: ImageVector by lazy {
        ImageVector.Builder("CouiInfo", 24.dp, 24.dp, 24f, 24f).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(11f, 10f)
                horizontalLineTo(13f)
                verticalLineTo(18f)
                horizontalLineTo(11f)
                close()
                moveTo(11f, 6f)
                horizontalLineTo(13f)
                verticalLineTo(8f)
                horizontalLineTo(11f)
                close()
            }
        }.build()
    }
}
