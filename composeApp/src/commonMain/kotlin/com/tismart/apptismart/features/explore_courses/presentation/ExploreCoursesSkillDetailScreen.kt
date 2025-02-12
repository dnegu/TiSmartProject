package com.tismart.apptismart.features.explore_courses.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import com.tismart.apptismart.features.enhance_learning.presentation.components.TiSmartLoversCourseDetailHeader
import com.tismart.apptismart.features.explore_courses.presentation.components.UdemyDialog
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyAction
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.explore_courses_skills_card

@Composable
fun ExploreCoursesSkillDetailScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit
) {
    ExploreCoursesSkillDetailScreen(
        onAction = { action ->
            when (action) {
                ExploreCoursesSkillsAction.OnProfileClick -> onProfileClick()
                ExploreCoursesSkillsAction.OnNotificationsClick -> onNotificationsClick()
                ExploreCoursesSkillsAction.OnBackClick -> onBackClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun ExploreCoursesSkillDetailScreen(
    onAction: (ExploreCoursesSkillsAction) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            notificationCount = 0,
            onMenuClick = { onAction(ExploreCoursesSkillsAction.OnProfileClick) },
            onNotificationsClick = { onAction(ExploreCoursesSkillsAction.OnNotificationsClick) },
            onBackClick = { onAction(ExploreCoursesSkillsAction.OnBackClick) }
        )

        TiSmartLoversCourseDetailHeader(
            image = Res.drawable.explore_courses_skills_card,
            name = "Microservicios con SpringBoot",
            description = "Mejora tus habilidades en Oracle PL/SQL. Avanza de nivel con lecciones y ejercicios prácticos diseñados para ti.",
            author = "Duración: 2h",
            courseLevel = CourseLevel.BEGINNER
        )

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 18.dp, bottom = 4.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimarioMedium,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Ir a Udemy",
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
    UdemyDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onGoToUdemyClick = { showDialog = false }
    )
}