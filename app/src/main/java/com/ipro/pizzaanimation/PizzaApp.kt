package com.ipro.pizzaanimation

import android.app.Application
import com.ipro.pizzaanimation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PizzaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PizzaApp)
            //androidLogger()
            modules(appModule)
        }
    }
}
