package br.com.omanoloneto.vnavenda.di

import androidx.room.Room
import br.com.omanoloneto.vnavenda.data.AppDatabase
import br.com.omanoloneto.vnavenda.viewmodels.ShoppingListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Provide Database
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "vna_venda_database").build()
    }

    // Provide DAO
    single { get<AppDatabase>().shoppingItemDao() }

    // Provide ViewModel
    viewModel { ShoppingListViewModel(get()) }
}