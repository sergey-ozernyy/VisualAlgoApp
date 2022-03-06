package com.example.androidvisualalgoapp

import android.app.Application
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(ciceroneModule)
        }
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}