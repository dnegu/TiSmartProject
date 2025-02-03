package com.tismart.apptismart

import android.app.Application
import com.tismart.apptismart.di.initKoin
import org.koin.android.ext.koin.androidContext

class TiSmartApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TiSmartApplication)
        }
    }
}