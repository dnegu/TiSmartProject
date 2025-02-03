package com.tismart.apptismart

import androidx.compose.ui.window.ComposeUIViewController
import com.tismart.apptismart.app.App
import com.tismart.apptismart.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }