package br.com.manoloneto.vnavenda.di

import androidx.room.Room
import br.com.manoloneto.vnavenda.data.AppDatabase
import br.com.manoloneto.vnavenda.viewmodels.ShoppingListViewModel
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