package com.tismart.apptismart.features.discover_benefits

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
import com.tismart.apptismart.features.discover_benefits.components.DiscoverBenefitsCard
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.discover_benefits_card

@Composable
fun DiscoverMyFavoriteBenefitsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Mis favoritos",
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
                DiscoverBenefitsCard(
                    image = Res.drawable.discover_benefits_card,
                    discount = 50,
                    name = "La Tarumba",
                    description = "Aprovecha esta oportunidad única para vivir tus eventos favoritos blab blal blalssls blla lblddldl",
                    onCardClick = {}
                )
            }
        }
    }
}