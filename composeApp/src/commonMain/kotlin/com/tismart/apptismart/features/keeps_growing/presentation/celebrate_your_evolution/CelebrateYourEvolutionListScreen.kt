package com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution

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
import com.tismart.apptismart.features.keeps_growing.presentation.components.CelebrateYourEvolutionListCard
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.keeps_growing_card

@Composable
fun CelebrateYourEvolutionListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Celebramos tu evolución \uD83C\uDF89",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(10) {
                CelebrateYourEvolutionListCard(
                    image = Res.drawable.keeps_growing_card,
                    favoriteCount = 10,
                    label = "UX Designer",
                    name = "Carlina del Pilar",
                    description = "Por haber obtenido un buen rendimiento y haber brindado una buena propuesta, te felicitamos en este ascenso de Technical Leader a Support Analyst.",
                    onCardClick = {}
                )
            }
        }
    }
}