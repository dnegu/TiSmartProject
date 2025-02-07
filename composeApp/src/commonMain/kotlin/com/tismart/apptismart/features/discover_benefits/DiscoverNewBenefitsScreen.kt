package com.tismart.apptismart.features.discover_benefits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader

@Composable
fun DiscoverNewBenefitsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Nuevos",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )
    }
}