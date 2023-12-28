package ru.example.project1

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import ru.example.project1.di.appModule
import ru.example.project1.di.dataModule
import ru.example.project1.di.domainModule

class StoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            allowOverride(false)
            androidContext(this@StoreApplication)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}