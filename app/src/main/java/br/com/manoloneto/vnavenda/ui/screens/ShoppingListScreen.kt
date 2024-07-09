package br.com.manoloneto.vnavenda.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import br.com.manoloneto.vnavenda.ui.composables.ShoppingItemRow
import br.com.manoloneto.vnavenda.viewmodels.ShoppingListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel = koinViewModel()) {
    val shoppingItems by viewModel.shoppingItems.observeAsState(initial = emptyList())

    LazyColumn {
        items(shoppingItems) { item ->
            ShoppingItemRow(item, onCheckedChange = { updatedItem ->
                viewModel.updateItem(updatedItem)
            })
        }
    }
}
