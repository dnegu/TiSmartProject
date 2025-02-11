package com.tismart.apptismart.features.explore_courses.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsSearchBar
import com.tismart.apptismart.features.enhance_learning.presentation.components.EnhanceLearningListPager
import com.tismart.apptismart.features.explore_courses.presentation.components.ExploreNewCoursesGrid

@Composable
fun ExploreNewCoursesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Explora nuevos cursos",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        DiscoverBenefitsSearchBar(
            text = "¿Qué quieres aprender hoy?",
            onSearchBarClick = {}
        )

        ExploreNewCoursesGrid(
            onFrontendClick = {},
            onBackendClick = {},
            onFullstackClick = {},
            onUxUiClick = {},
            onMarketingClick = {},
            onQaClick = {}
        )

        EnhanceLearningListPager(
            title = "Recomendados para ti",
            onSeeAllClick = {}
        )
    }
}