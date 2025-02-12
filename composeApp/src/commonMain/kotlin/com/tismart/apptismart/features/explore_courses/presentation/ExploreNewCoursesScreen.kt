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
import com.tismart.apptismart.features.enhance_learning.presentation.home.EnhanceLearningAction
import com.tismart.apptismart.features.enhance_learning.presentation.home.EnhanceYourLearningScreen
import com.tismart.apptismart.features.explore_courses.presentation.components.ExploreNewCoursesGrid

@Composable
fun ExploreNewCoursesScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onSearchForCoursesClick: () -> Unit,
    onSkillClick: (String) -> Unit,
    onSeeAllRecommendedCoursesClick: () -> Unit,
    onRecommendedCourseCardClick: () -> Unit
) {
    ExploreNewCoursesScreen(
        onAction = { action ->
            when (action) {
                ExploreNewCoursesAction.OnProfileClick -> onProfileClick()
                ExploreNewCoursesAction.OnNotificationsClick -> onNotificationsClick()
                ExploreNewCoursesAction.OnBackClick -> onBackClick()
                ExploreNewCoursesAction.OnSearchForCoursesClick -> onSearchForCoursesClick()
                is ExploreNewCoursesAction.OnSkillClick -> onSkillClick(action.skill)
                ExploreNewCoursesAction.OnSeeAllRecommendedCoursesClick -> onSeeAllRecommendedCoursesClick()
                ExploreNewCoursesAction.OnRecommendedCourseCardClick -> onRecommendedCourseCardClick()
            }
        }
    )
}

@Composable
fun ExploreNewCoursesScreen(
    onAction: (ExploreNewCoursesAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Explora nuevos cursos",
            notificationCount = 0,
            onMenuClick = { onAction(ExploreNewCoursesAction.OnProfileClick) },
            onNotificationsClick = { onAction(ExploreNewCoursesAction.OnNotificationsClick) },
            onBackClick = { onAction(ExploreNewCoursesAction.OnBackClick) }
        )

        DiscoverBenefitsSearchBar(
            text = "¿Qué quieres aprender hoy?",
            onSearchBarClick = { onAction(ExploreNewCoursesAction.OnSearchForCoursesClick) }
        )

        ExploreNewCoursesGrid(
            onFrontendClick = { onAction(ExploreNewCoursesAction.OnSkillClick("Frontend")) },
            onBackendClick = { onAction(ExploreNewCoursesAction.OnSkillClick("Backend")) },
            onFullstackClick = { onAction(ExploreNewCoursesAction.OnSkillClick("Fullstack")) },
            onUxUiClick = { onAction(ExploreNewCoursesAction.OnSkillClick("UX/UI")) },
            onMarketingClick = { onAction(ExploreNewCoursesAction.OnSkillClick("Marketing")) },
            onQaClick = { onAction(ExploreNewCoursesAction.OnSkillClick("QA")) }
        )

        EnhanceLearningListPager(
            title = "Recomendados para ti",
            onSeeAllClick = { onAction(ExploreNewCoursesAction.OnSeeAllRecommendedCoursesClick) },
            onCardClick = { onAction(ExploreNewCoursesAction.OnRecommendedCourseCardClick) }
        )
    }
}