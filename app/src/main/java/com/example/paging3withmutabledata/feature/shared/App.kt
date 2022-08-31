package com.example.paging3withmutabledata.feature.shared

import android.app.Application
import com.example.paging3withmutabledata.feature.characters.list.di.characterModule
import com.example.paging3withmutabledata.feature.shared.networking.di.networkingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            allowOverride(true)
            androidContext(this@App)
            modules(characterModule + networkingModule)
        }
    }
}
