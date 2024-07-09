package br.com.omanoloneto.vnavenda.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import br.com.omanoloneto.vnavenda.data.entities.ShoppingItem
import br.com.omanoloneto.vnavenda.ui.composables.NewItemBottomSheet
import br.com.omanoloneto.vnavenda.ui.composables.ShoppingItemRow
import br.com.omanoloneto.vnavenda.viewmodels.ShoppingListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel = koinViewModel()) {
    val shoppingItems by viewModel.shoppingItems.observeAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    bottomSheetState.show()
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new item")
            }

        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(shoppingItems) { item ->
                ShoppingItemRow(item, onCheckedChange = { updatedItem ->
                    viewModel.updateItem(updatedItem)
                })
            }
        }

        if(bottomSheetState.isVisible) {
            NewItemBottomSheet(bottomSheetState = bottomSheetState, onItemCreate = { itemName ->
                val newItem = ShoppingItem(id = 0, name = itemName, isChecked = false)
                viewModel.addItem(newItem)
                scope.launch {
                    bottomSheetState.hide()
                }
            })
        }
    }
}

