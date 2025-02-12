package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

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
import com.tismart.apptismart.features.keeps_growing.presentation.components.OurMentorsListCard
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathAction
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreen
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.explore_mentors_card

@Composable
fun OurMentorsListScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onMentorCardClick: () -> Unit
) {
    OurMentorsListScreen(
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
fun OurMentorsListScreen(
    onAction: (ExploreMentorsAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Nuestros mentores",
            notificationCount = 0,
            onMenuClick = { onAction(ExploreMentorsAction.OnProfileClick) },
            onNotificationsClick = { onAction(ExploreMentorsAction.OnNotificationsClick) },
            onBackClick = { onAction(ExploreMentorsAction.OnBackClick) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(10) {
                OurMentorsListCard(
                    image = Res.drawable.explore_mentors_card,
                    name = "Angela Ramos",
                    description = "Experiencia de 3 años en UX, Angular e inteligencia.",
                    label = "UX Designer",
                    onCardClick = { onAction(ExploreMentorsAction.OnMentorCardClick) }
                )
            }
        }
    }
}