package com.tismart.apptismart.features.enhance_learning.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.KeepsGrowingCard
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyAction
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.enhance_your_learning_card1
import tismartproject.composeapp.generated.resources.enhance_your_learning_card2
import tismartproject.composeapp.generated.resources.enhance_your_learning_card3

@Composable
fun EnhanceYourLearningScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onExploreNewCoursesClick: () -> Unit,
    onTiSmartUniversityClick: () -> Unit,
    onEducationalAgreementClick: () -> Unit
) {
    EnhanceYourLearningScreen(
        onAction = { action ->
            when (action) {
                EnhanceLearningAction.OnProfileClick -> onProfileClick()
                EnhanceLearningAction.OnNotificationsClick -> onNotificationsClick()
                EnhanceLearningAction.OnBackClick -> onBackClick()
                EnhanceLearningAction.OnExploreNewCoursesClick -> onExploreNewCoursesClick()
                EnhanceLearningAction.OnTiSmartUniversityClick -> onTiSmartUniversityClick()
                EnhanceLearningAction.OnEducationalAgreementClick -> onEducationalAgreementClick()
            }
        }
    )
}

@Composable
fun EnhanceYourLearningScreen(
    onAction: (EnhanceLearningAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Potencia tu aprendizaje",
            notificationCount = 0,
            onMenuClick = { onAction(EnhanceLearningAction.OnProfileClick) },
            onNotificationsClick = { onAction(EnhanceLearningAction.OnNotificationsClick) },
            onBackClick = { onAction(EnhanceLearningAction.OnBackClick) }
        )

        Text(
            text = "¡Descubre cursos y recursos para potenciar tus habilidades y seguir creciendo con Tismart! \uD83D\uDE80",
            color = NeutralDark,
            modifier = Modifier.padding(30.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(HomeBackground)
                .padding(horizontal = 30.dp, vertical = 34.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Text(
                text = "¡Tu aprendizaje empieza aquí!",
                modifier = Modifier.padding(bottom = 6.dp),
                color = SecundarioDark,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge
            )

            KeepsGrowingCard(
                icon = Res.drawable.enhance_your_learning_card1,
                text = "Explora nuevos cursos",
                onClick = { onAction(EnhanceLearningAction.OnExploreNewCoursesClick) }
            )

            KeepsGrowingCard(
                icon = Res.drawable.enhance_your_learning_card2,
                text = "TiSmart University",
                onClick = { onAction(EnhanceLearningAction.OnTiSmartUniversityClick) }
            )

            KeepsGrowingCard(
                icon = Res.drawable.enhance_your_learning_card3,
                text = "Convenio Educativo",
                onClick = { onAction(EnhanceLearningAction.OnEducationalAgreementClick) }
            )
        }
    }
}