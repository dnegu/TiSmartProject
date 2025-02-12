package com.tismart.apptismart.features.enhance_learning.presentation.tismart_university

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import com.tismart.apptismart.features.enhance_learning.presentation.components.TiSmartLoversCourseListCard
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyAction
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.tismart_university_card

@Composable
fun TiSmartLoversCourseListScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onTiSmartLoversCourseCardClick: () -> Unit
) {
    TiSmartLoversCourseListScreen(
        onAction = { action ->
            when (action) {
                TiSmartLoversAction.OnProfileClick -> onProfileClick()
                TiSmartLoversAction.OnNotificationsClick -> onNotificationsClick()
                TiSmartLoversAction.OnBackClick -> onBackClick()
                TiSmartLoversAction.OnTiSmartLoversCourseCardClick -> onTiSmartLoversCourseCardClick()
            }
        }
    )
}

@Composable
fun TiSmartLoversCourseListScreen(
    onAction: (TiSmartLoversAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Cursos TiSmartLovers",
            notificationCount = 0,
            onMenuClick = { onAction(TiSmartLoversAction.OnProfileClick) },
            onNotificationsClick = { onAction(TiSmartLoversAction.OnNotificationsClick) },
            onBackClick = { onAction(TiSmartLoversAction.OnBackClick) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(10) {
                TiSmartLoversCourseListCard(
                    image = Res.drawable.tismart_university_card,
                    name = "El arte de QA en tiempos actuales",
                    description = "Testing de Software y automatización",
                    author = "Franco Muschi",
                    courseLevel = CourseLevel.INTERMEDIATE,
                    onCardClick = { onAction(TiSmartLoversAction.OnTiSmartLoversCourseCardClick) }
                )
            }
        }
    }
}