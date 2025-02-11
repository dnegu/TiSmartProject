package com.tismart.apptismart.features.vacancy.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.vacancy.presentation.components.VacancyCard

@Composable
fun VacanciesRecommendedForYouScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Recomendados para ti",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(10) {
                VacancyCard(
                    name = "Service Design",
                    isNew = it % 2 == 0,
                    location = "Lima, Perú. (En remoto)",
                    date = "12/04/24",
                    onCardClick = {}
                )
                HorizontalDivider(color = NeutralLight)
            }
        }
    }
}