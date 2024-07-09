package br.com.omanoloneto.vnavenda.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewItemBottomSheet(
    bottomSheetState: SheetState,
    onItemCreate: (String) -> Unit
) {
    val itemName = remember { mutableStateOf(TextFieldValue("")) }

    ModalBottomSheet(
        onDismissRequest = { },
        sheetState = bottomSheetState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(text = "New item", style = MaterialTheme.typography.titleLarge)
                OutlinedTextField(
                    value = itemName.value,
                    onValueChange = { itemName.value = it },
                    label = { "Item name" },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {
                        if (itemName.value.text.isNotEmpty()) {
                            onItemCreate(itemName.value.text)
                        }
                    }) {
                    Text(text = "Add item")
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}