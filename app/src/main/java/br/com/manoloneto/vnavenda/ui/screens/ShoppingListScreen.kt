package br.com.manoloneto.vnavenda.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import br.com.manoloneto.vnavenda.viewmodels.ShoppingListViewModel
import br.com.manoloneto.vnavenda.ui.composables.ShoppingItemRow
import java.util.Collections.emptyList

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel = hiltViewModel()) {
    val shoppingItems by viewModel.shoppingItems.observeAsState(initial = emptyList())

    LazyColumn {
        items(shoppingItems) { item ->
            ShoppingItemRow(item, onCheckedChange = { updatedItem ->
                viewModel.updateItem(updatedItem)
            })
        }
    }
}
