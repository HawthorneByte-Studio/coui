package me.hawthorne.coui.example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import me.hawthorne.coui.ui.CouiBottomSheet
import me.hawthorne.coui.ui.CouiButton
import me.hawthorne.coui.ui.CouiCard
import me.hawthorne.coui.ui.CouiDialog
import me.hawthorne.coui.ui.CouiInfoBanner
import me.hawthorne.coui.ui.CouiNavigationBar
import me.hawthorne.coui.ui.CouiNavigationItem
import me.hawthorne.coui.ui.CouiScaffold
import me.hawthorne.coui.ui.CouiSnackbarHost
import me.hawthorne.coui.ui.CouiTheme
import me.hawthorne.coui.ui.CouiTopBar

private val destinations = listOf("Home", "Controls", "Pickers")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleApp() {
    CouiTheme {
        var selectedDestination by remember { mutableStateOf(0) }
        var dialogVisible by remember { mutableStateOf(false) }
        var sheetVisible by remember { mutableStateOf(false) }
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        CouiScaffold(
            topBar = { CouiTopBar(title = "COUI Showcase") },
            bottomBar = {
                CouiNavigationBar(
                    items = destinations.mapIndexed { index, label ->
                        CouiNavigationItem(
                            label = label,
                            selected = selectedDestination == index,
                            onClick = { selectedDestination = index },
                        )
                    },
                )
            },
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(contentPadding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    when (selectedDestination) {
                        0 -> HomeScreen(
                            onDialog = { dialogVisible = true },
                            onSheet = { sheetVisible = true },
                            onSnackbar = {
                                scope.launch { snackbarHostState.showSnackbar("COUI action completed") }
                            },
                        )
                        1 -> ControlsScreen()
                        else -> PickersScreen()
                    }
                }
            }
            CouiSnackbarHost(modifier = Modifier.padding(16.dp), hostState = snackbarHostState)
            if (dialogVisible) {
                CouiDialog(
                    title = "COUI Dialog",
                    message = "This dialog is rendered by the reusable coui module.",
                    onDismissRequest = { dialogVisible = false },
                    onConfirm = { dialogVisible = false },
                )
            }
            if (sheetVisible) {
                CouiBottomSheet(onDismissRequest = { sheetVisible = false }) {
                    Text("COUI BottomSheet", style = MaterialTheme.typography.titleLarge)
                    CouiButton(text = "Close", onClick = { sheetVisible = false })
                }
            }
        }
    }
}
