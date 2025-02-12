package com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.CelebrateYourEvolutionDetailHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.CelebrateYourEvolutionDetailPager
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.keeps_growing_card

@Composable
fun CelebrateYourEvolutionDetailScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onColleagueCardClick: () -> Unit
) {
    CelebrateYourEvolutionDetailScreen(
        onAction = { action ->
            when (action) {
                CelebrateYourEvolutionAction.OnProfileClick -> onProfileClick()
                CelebrateYourEvolutionAction.OnNotificationsClick -> onNotificationsClick()
                CelebrateYourEvolutionAction.OnBackClick -> onBackClick()
                CelebrateYourEvolutionAction.OnColleagueCardClick -> onColleagueCardClick()
            }
        }
    )
}

@Composable
fun CelebrateYourEvolutionDetailScreen(
    onAction: (CelebrateYourEvolutionAction) -> Unit
) {
    val (isFavorite, onFavoriteClick) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            notificationCount = 0,
            onMenuClick = { onAction(CelebrateYourEvolutionAction.OnProfileClick) },
            onNotificationsClick = { onAction(CelebrateYourEvolutionAction.OnNotificationsClick) },
            onBackClick = { onAction(CelebrateYourEvolutionAction.OnBackClick) }
        )

        CelebrateYourEvolutionDetailHeader(
            image = Res.drawable.keeps_growing_card,
            label = "UX Designer",
            name = "Carlina del Pilar",
            description = "Por haber obtenido un buen rendimiento y haber brindado una buena propuesta, te felicitamos en este ascenso de Technical Leader a Support Analyst. \uD83D\uDE80\uD83E\uDD13\uD83D\uDC68\u200D\uD83D\uDCBB",
            isFavorite = isFavorite,
            favoriteCount = 11,
            onFavoriteClick = onFavoriteClick
        )

        CelebrateYourEvolutionDetailPager(
            onCardClick = { onAction(CelebrateYourEvolutionAction.OnColleagueCardClick) }
        )
    }
}