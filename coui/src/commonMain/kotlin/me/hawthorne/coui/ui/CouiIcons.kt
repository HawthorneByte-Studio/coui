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
}
