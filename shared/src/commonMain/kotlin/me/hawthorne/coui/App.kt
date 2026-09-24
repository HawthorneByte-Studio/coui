package me.hawthorne.coui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.hawthorne.coui.ui.CouiButton
import me.hawthorne.coui.ui.CouiCard
import me.hawthorne.coui.ui.CouiListItem
import me.hawthorne.coui.ui.CouiSwitch
import me.hawthorne.coui.ui.CouiTextField
import me.hawthorne.coui.ui.CouiTheme
import me.hawthorne.coui.ui.CouiTopBar

@Composable
@Preview
fun App() {
    CouiTheme {
        var enabled by remember { mutableStateOf(true) }
        var text by remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize()) {
            CouiTopBar(title = "COUI")
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    CouiCard {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text("ColorOS UI foundation")
                            Text(
                                text = "A Compose Multiplatform starting point for COUI components.",
                                modifier = Modifier.padding(top = 8.dp),
                            )
                        }
                    }
                }
                item {
                    CouiCard {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text("Controls")
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                CouiSwitch(
                                    checked = enabled,
                                    onCheckedChange = { enabled = it },
                                    label = "Enable COUI theme",
                                )
                            }
                        }
                    }
                }
                item {
                    CouiCard {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            Text("Actions")
                            CouiTextField(
                                value = text,
                                onValueChange = { text = it },
                                label = "Name",
                                placeholder = "Enter a value",
                            )
                            CouiButton(text = "Primary action", onClick = {}, enabled = enabled)
                        }
                    }
                }
                item {
                    CouiCard {
                        CouiListItem(
                            title = "Component list item",
                            subtitle = "Reusable title and subtitle layout",
                            onClick = {},
                        )
                    }
                }
            }
        }
    }
}
