package com.tismart.apptismart.features.enhance_learning.presentation.tismart_university

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.components.TiSmartUniversityCertificates
import com.tismart.apptismart.features.enhance_learning.presentation.components.EnhanceLearningListPager
import com.tismart.apptismart.features.enhance_learning.presentation.components.TiSmartUniversityPager

@Composable
fun TiSmartUniversityScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "TISmart University",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        TiSmartUniversityPager()

        EnhanceLearningListPager(
            title = "Cursos TiSmartLovers",
            onSeeAllClick = {}
        )

        TiSmartUniversityCertificates(
            onDownloadClick = {}
        )
    }
}