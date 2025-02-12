package com.tismart.apptismart.features.explore_courses.presentation

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
import tismartproject.composeapp.generated.resources.explore_courses_skills_card

@Composable
fun ExploreCoursesSkillsListScreenRoot(
    title: String,
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onCourseCardClick: () -> Unit
) {
    ExploreCoursesSkillsListScreen(
        title = title,
        onAction = { action ->
            when (action) {
                ExploreCoursesSkillsAction.OnProfileClick -> onProfileClick()
                ExploreCoursesSkillsAction.OnNotificationsClick -> onNotificationsClick()
                ExploreCoursesSkillsAction.OnBackClick -> onBackClick()
                ExploreCoursesSkillsAction.OnCourseCardClick -> onCourseCardClick()
            }
        }
    )
}

@Composable
fun ExploreCoursesSkillsListScreen(
    title: String,
    onAction: (ExploreCoursesSkillsAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = title,
            notificationCount = 0,
            onMenuClick = { onAction(ExploreCoursesSkillsAction.OnProfileClick) },
            onNotificationsClick = { onAction(ExploreCoursesSkillsAction.OnNotificationsClick) },
            onBackClick = { onAction(ExploreCoursesSkillsAction.OnBackClick) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(10) {
                TiSmartLoversCourseListCard(
                    image = Res.drawable.explore_courses_skills_card,
                    name = "Microservicios con SpringBoot",
                    description = "Mejora tus habilidades en Oracle PL/SQL. Avanza de nivel con lecciones y ejercicios prácticos diseñados para ti.",
                    author = "Duración: 2h",
                    courseLevel = CourseLevel.BEGINNER,
                    onCardClick = { onAction(ExploreCoursesSkillsAction.OnCourseCardClick) }
                )
            }
        }
    }
}