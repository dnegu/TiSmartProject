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
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyAction

@Composable
fun TiSmartUniversityScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onEventClick: () -> Unit,
    onSeeAllTiSmartLoversCoursesClick: () -> Unit,
    onTiSmartLoversCourseCardClick: () -> Unit
) {
    TiSmartUniversityScreen(
        onAction = { action ->
            when (action) {
                TiSmartUniversityAction.OnProfileClick -> onProfileClick()
                TiSmartUniversityAction.OnNotificationsClick -> onNotificationsClick()
                TiSmartUniversityAction.OnBackClick -> onBackClick()
                TiSmartUniversityAction.OnEventClick -> onEventClick()
                TiSmartUniversityAction.OnSeeAllTiSmartLoversCoursesClick -> onSeeAllTiSmartLoversCoursesClick()
                TiSmartUniversityAction.OnTiSmartLoversCourseCardClick -> onTiSmartLoversCourseCardClick()
            }
        }
    )
}

@Composable
fun TiSmartUniversityScreen(
    onAction: (TiSmartUniversityAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "TISmart University",
            notificationCount = 0,
            onMenuClick = { onAction(TiSmartUniversityAction.OnProfileClick) },
            onNotificationsClick = { onAction(TiSmartUniversityAction.OnNotificationsClick) },
            onBackClick = { onAction(TiSmartUniversityAction.OnBackClick) }
        )

        TiSmartUniversityPager(
            onItemClick = { onAction(TiSmartUniversityAction.OnEventClick) }
        )

        EnhanceLearningListPager(
            title = "Cursos TiSmartLovers",
            onSeeAllClick = { onAction(TiSmartUniversityAction.OnSeeAllTiSmartLoversCoursesClick) },
            onCardClick = { onAction(TiSmartUniversityAction.OnTiSmartLoversCourseCardClick) }
        )

        TiSmartUniversityCertificates(
            onDownloadClick = {}
        )
    }
}