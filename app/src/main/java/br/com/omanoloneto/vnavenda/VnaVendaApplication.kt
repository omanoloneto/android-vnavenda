package br.com.omanoloneto.vnavenda

import android.app.Application
import br.com.omanoloneto.vnavenda.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class VnaVendaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VnaVendaApplication)
            modules(appModule)
        }
    }
}