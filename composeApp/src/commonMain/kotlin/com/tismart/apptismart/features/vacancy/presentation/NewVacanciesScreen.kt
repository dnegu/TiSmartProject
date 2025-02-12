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
fun NewVacanciesScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onVacancyCardClick: () -> Unit
) {
    NewVacanciesScreen(
        onAction = { action ->
            when (action) {
                VacancyAction.OnProfileClick -> onProfileClick()
                VacancyAction.OnNotificationsClick -> onNotificationsClick()
                VacancyAction.OnBackClick -> onBackClick()
                VacancyAction.OnVacancyCardClick -> onVacancyCardClick()
            }
        }
    )
}

@Composable
fun NewVacanciesScreen(
    onAction: (VacancyAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Nuevas vacantes",
            notificationCount = 0,
            onMenuClick = { onAction(VacancyAction.OnProfileClick) },
            onNotificationsClick = { onAction(VacancyAction.OnNotificationsClick) },
            onBackClick = { onAction(VacancyAction.OnBackClick) }
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
                    onCardClick = { onAction(VacancyAction.OnVacancyCardClick) }
                )
                HorizontalDivider(color = NeutralLight)
            }
        }
    }
}