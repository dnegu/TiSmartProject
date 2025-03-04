package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.OurMentorsDetailHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.OurMentorsDetailPager
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.explore_mentors_card

@Composable
fun OurMentorsDetailScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onMentorCardClick: () -> Unit
) {
    OurMentorsDetailScreen(
        onAction = { action ->
            when (action) {
                ExploreMentorsAction.OnProfileClick -> onProfileClick()
                ExploreMentorsAction.OnNotificationsClick -> onNotificationsClick()
                ExploreMentorsAction.OnBackClick -> onBackClick()
                ExploreMentorsAction.OnMentorCardClick -> onMentorCardClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun OurMentorsDetailScreen(
    onAction: (ExploreMentorsAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            notificationCount = 0,
            onMenuClick = { onAction(ExploreMentorsAction.OnProfileClick) },
            onNotificationsClick = { onAction(ExploreMentorsAction.OnNotificationsClick) },
            onBackClick = { onAction(ExploreMentorsAction.OnBackClick) }
        )

        OurMentorsDetailHeader(
            image = Res.drawable.explore_mentors_card,
            label = "UX Designer",
            name = "Angela Ramos",
            description = "Experiencia de 3 años en UX, con un enfoque en crear interfaces intuitivas y centradas en el usuario. Amplio manejo de Angular para desarrollar aplicaciones web dinámicas y escalables, además de experiencia en la aplicación de inteligencia artificial para mejorar la personalización y optimización de la experiencia del usuario."
        )

        OurMentorsDetailPager(
            onCardClick = { onAction(ExploreMentorsAction.OnMentorCardClick) },
        )
    }
}