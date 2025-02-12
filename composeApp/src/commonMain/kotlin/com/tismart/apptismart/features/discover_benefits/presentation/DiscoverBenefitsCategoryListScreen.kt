package com.tismart.apptismart.features.discover_benefits.presentation

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
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsCard
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.discover_benefits_card

@Composable
fun DiscoverBenefitsCategoryListScreenRoot(
    title: String,
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onBenefitCardClick: () -> Unit
) {
    DiscoverBenefitsCategoryListScreen(
        title = title,
        onAction = { action ->
            when (action) {
                DiscoverBenefitsAction.OnProfileClick -> onProfileClick()
                DiscoverBenefitsAction.OnNotificationsClick -> onNotificationsClick()
                DiscoverBenefitsAction.OnBackClick -> onBackClick()
                DiscoverBenefitsAction.OnBenefitCardClick -> onBenefitCardClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun DiscoverBenefitsCategoryListScreen(
    title: String,
    onAction: (DiscoverBenefitsAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = title,
            notificationCount = 0,
            onMenuClick = { onAction(DiscoverBenefitsAction.OnProfileClick) },
            onNotificationsClick = { onAction(DiscoverBenefitsAction.OnNotificationsClick) },
            onBackClick = { onAction(DiscoverBenefitsAction.OnBackClick) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(10) {
                DiscoverBenefitsCard(
                    image = Res.drawable.discover_benefits_card,
                    discount = 50,
                    name = "La Tarumba",
                    description = "Aprovecha esta oportunidad única para vivir tus eventos favoritos blab blal blalssls blla lblddldl",
                    onCardClick = { onAction(DiscoverBenefitsAction.OnBenefitCardClick) }
                )
            }
        }
    }
}