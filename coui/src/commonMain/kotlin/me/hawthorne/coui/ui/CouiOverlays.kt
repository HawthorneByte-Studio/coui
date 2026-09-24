package me.hawthorne.coui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

@Composable
fun CouiDialog(
    title: String,
    message: String,
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    confirmText: String = "Confirm",
    dismissText: String? = "Cancel",
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = Modifier
            .widthIn(max = CouiTokens.Components.AlertDialogMaxWidth)
            .heightIn(max = CouiTokens.Components.AlertDialogMaxHeight),
        shape = RoundedCornerShape(CouiTokens.Corners.AlertDialog),
        containerColor = MaterialTheme.colorScheme.surface,
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            CouiButton(
                text = confirmText,
                onClick = onConfirm,
                modifier = Modifier.heightIn(min = CouiTokens.Components.AlertDialogButtonHeight),
            )
        },
        dismissButton = dismissText?.let { text ->
            {
                CouiButton(
                    text = text,
                    onClick = onDismissRequest,
                    modifier = Modifier.heightIn(min = CouiTokens.Components.AlertDialogButtonHeight),
                )
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CouiBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = CouiShape,
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            content = content,
        )
    }
}
