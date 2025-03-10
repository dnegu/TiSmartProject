package com.tismart.apptismart.features.keeps_growing.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.tismart.apptismart.features.keeps_growing.presentation.components.KeepsGrowingPager
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.keeps_growing_card1
import tismartproject.composeapp.generated.resources.keeps_growing_card2
import tismartproject.composeapp.generated.resources.keeps_growing_card3

@Composable
fun KeepsGrowingScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onSeeAllColleaguesClick: () -> Unit,
    onGrowthPathClick: () -> Unit,
    onInnovateAndTransformClick: () -> Unit,
    onExploreMentorsClick: () -> Unit
) {
    KeepsGrowingScreen(
        onAction = { action ->
            when (action) {
                KeepsGrowingAction.OnProfileClick -> onProfileClick()
                KeepsGrowingAction.OnNotificationsClick -> onNotificationsClick()
                KeepsGrowingAction.OnBackClick -> onBackClick()
                KeepsGrowingAction.OnSeeAllColleaguesClick -> onSeeAllColleaguesClick()
                KeepsGrowingAction.OnGrowthPathClick -> onGrowthPathClick()
                KeepsGrowingAction.OnInnovateAndTransformClick -> onInnovateAndTransformClick()
                KeepsGrowingAction.OnExploreMentorsClick -> onExploreMentorsClick()
            }
        }
    )
}

@Composable
fun KeepsGrowingScreen(
    onAction: (KeepsGrowingAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Sigue creciendo",
            notificationCount = 0,
            onMenuClick = { onAction(KeepsGrowingAction.OnProfileClick) },
            onNotificationsClick = { onAction(KeepsGrowingAction.OnNotificationsClick) },
            onBackClick = { onAction(KeepsGrowingAction.OnBackClick) }
        )

        Text(
            text = "Aquí celebramos tus logros y te ayudamos a alcanzar tu máximo potencial.",
            color = NeutralDark,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        KeepsGrowingPager(
            onSeeAllClick = { onAction(KeepsGrowingAction.OnSeeAllColleaguesClick) }
        )

        Column(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .background(HomeBackground)
                .padding(horizontal = 30.dp, vertical = 34.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Text(
                text = "¡Tu crecimiento empieza aquí!",
                modifier = Modifier.padding(bottom = 6.dp),
                color = SecundarioDark,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge
            )

            KeepsGrowingCard(
                icon = Res.drawable.keeps_growing_card1,
                text = "Tu ruta de crecimiento",
                onClick = { onAction(KeepsGrowingAction.OnGrowthPathClick) }
            )

            KeepsGrowingCard(
                icon = Res.drawable.keeps_growing_card2,
                text = "Innova y Transforma",
                onClick = { onAction(KeepsGrowingAction.OnInnovateAndTransformClick) }
            )

            KeepsGrowingCard(
                icon = Res.drawable.keeps_growing_card3,
                text = "Explora mentores",
                onClick = { onAction(KeepsGrowingAction.OnExploreMentorsClick) }
            )
        }
    }
}