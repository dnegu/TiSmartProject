package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.components.TISmartActionButton
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.ExploreMentorsPager
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathAction
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreen
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.business_man

@Composable
fun ExploreMentorsScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onSeeAllMentorsClick: () -> Unit,
    onMentorCardClick: () -> Unit,
    onApplyHereClick: () -> Unit
) {
    ExploreMentorsScreen(
        onAction = { action ->
            when (action) {
                ExploreMentorsAction.OnProfileClick -> onProfileClick()
                ExploreMentorsAction.OnNotificationsClick -> onNotificationsClick()
                ExploreMentorsAction.OnBackClick -> onBackClick()
                ExploreMentorsAction.OnSeeAllMentorsClick -> onSeeAllMentorsClick()
                ExploreMentorsAction.OnMentorCardClick -> onMentorCardClick()
                ExploreMentorsAction.OnApplyHereClick -> onApplyHereClick()
            }
        }
    )
}

@Composable
fun ExploreMentorsScreen(
    onAction: (ExploreMentorsAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Explora mentores",
            notificationCount = 0,
            onMenuClick = { onAction(ExploreMentorsAction.OnProfileClick) },
            onNotificationsClick = { onAction(ExploreMentorsAction.OnNotificationsClick) },
            onBackClick = { onAction(ExploreMentorsAction.OnBackClick) }
        )

        Text(
            text = "Conoce a los expertos o sé el mentor que inspire a otros. ¡Vamos por más! \uD83D\uDE80",
            color = NeutralDarkest,
            modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 30.dp, bottom = 15.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        ExploreMentorsPager(
            onSeeAllClick = { onAction(ExploreMentorsAction.OnSeeAllMentorsClick) },
            onCardClick = { onAction(ExploreMentorsAction.OnMentorCardClick) }
        )

        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.large)
                .background(HomeBackground)
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(Res.drawable.business_man),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.width(120.dp)
            )
            Text(
                text = "¿Te gustaría ser mentor?",
                color = NeutralDarkest,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Inspira y guía a otros para que alcancen su próximo nivel. ¡Únete como mentor y marca la diferencia!",
                color = NeutralDarkest,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            TISmartActionButton(
                text = "Postula aquí",
                isLoading = false,
                onClick = { onAction(ExploreMentorsAction.OnApplyHereClick) }
            )
        }
    }
}