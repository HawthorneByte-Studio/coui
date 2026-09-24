package me.hawthorne.coui.ui

import androidx.compose.ui.unit.dp
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CouiInteractionTest {
    @Test
    fun publicIconsUseTheCouiVectorContract() {
        val icons = listOf(
            CouiIcons.Home,
            CouiIcons.Tune,
            CouiIcons.Calendar,
            CouiIcons.More,
            CouiIcons.Add,
            CouiIcons.Refresh,
            CouiIcons.Back,
            CouiIcons.Search,
            CouiIcons.Close,
            CouiIcons.Check,
            CouiIcons.ChevronRight,
            CouiIcons.Info,
            CouiIcons.AccountCircle,
            CouiIcons.Share,
            CouiIcons.Document,
        )

        assertEquals(15, icons.map { it.name }.distinct().size)
        icons.forEach { icon ->
            assertEquals(24.dp, icon.defaultWidth)
            assertEquals(24.dp, icon.defaultHeight)
            assertEquals(24f, icon.viewportWidth)
            assertEquals(24f, icon.viewportHeight)
            assertTrue(icon.name.startsWith("Coui"))
        }
    }

    @Test
    fun navigationItemInvokesItsAction() {
        var clicks = 0
        val item = CouiNavigationItem(
            label = "Home",
            selected = true,
            onClick = { clicks++ },
            badge = "2",
        )

        item.onClick()
        item.onClick()

        assertEquals("Home", item.label)
        assertEquals(true, item.selected)
        assertEquals("2", item.badge)
        assertEquals(2, clicks)
    }

    @Test
    fun selectionModelsPreserveLabelsAndIndexes() {
        val segment = CouiSegment("Overview")
        val tab = CouiTabItem("Details")

        assertEquals("Overview", segment.label)
        assertEquals("Details", tab.label)

        val labels = listOf(segment.label, tab.label)
        assertEquals(1, labels.indexOf("Details"))
    }
}
