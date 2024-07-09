package br.com.manoloneto.vnavenda.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import br.com.manoloneto.vnavenda.data.entities.ShoppingItem
import br.com.manoloneto.vnavenda.ui.composables.ShoppingItemRow
import br.com.manoloneto.vnavenda.viewmodels.ShoppingListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel = koinViewModel()) {
    val shoppingItems by viewModel.shoppingItems.observeAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val newItem = ShoppingItem(id = 0, name = "New Item", isChecked = false)
                viewModel.addItem(newItem)
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
    }

}
