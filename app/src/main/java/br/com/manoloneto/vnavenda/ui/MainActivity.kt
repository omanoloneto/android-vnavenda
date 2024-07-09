package br.com.manoloneto.vnavenda.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.manoloneto.vnavenda.ui.screens.ShoppingListScreen
import br.com.manoloneto.vnavenda.viewmodels.ShoppingListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val shoppingListViewModel: ShoppingListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListScreen(viewModel = shoppingListViewModel)
        }
    }
}