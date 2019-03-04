package com.framgia.trainingclean.presentation

import android.app.Application
import com.framgia.trainingclean.presentation.di.modules
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules = modules)
    }
}