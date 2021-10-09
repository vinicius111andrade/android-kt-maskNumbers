package com.vdemelo.masknumbers

import android.app.Application
import com.vdemelo.masknumbers.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import timber.log.Timber

/**
 * Created by Vinicius Andrade on 10/9/2021.
 */

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val myModules: List<Module> =
            listOf(
                viewModelModule
            )

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(myModules)
        }
    }
}