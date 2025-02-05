package com.tismart.apptismart.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.check_profile
import tismartproject.composeapp.generated.resources.gift_box
import tismartproject.composeapp.generated.resources.graduation_hat
import tismartproject.composeapp.generated.resources.star_badge

@Composable
fun HomeGridWithCards(
    onKeepGrowingClick: () -> Unit,
    onEnhanceLearningClick: () -> Unit,
    onDiscoverNewVacanciesClick: () -> Unit,
    onDiscoverMyBenefitsClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 18.dp).padding(top = 8.dp, bottom = 18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(intrinsicSize = IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HomeCard(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                title = "Seguir creciendo",
                image = Res.drawable.star_badge,
                onClick = onKeepGrowingClick
            )
            HomeCard(
                modifier = Modifier.weight(1f),
                title = "Potenciar mi aprendizaje",
                image = Res.drawable.graduation_hat,
                onClick = onEnhanceLearningClick
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HomeCard(
                modifier = Modifier.weight(1f),
                title = "Buscar nuevas vacantes",
                image = Res.drawable.check_profile,
                onClick = onDiscoverNewVacanciesClick
            )
            HomeCard(
                modifier = Modifier.weight(1f),
                title = "Descubrir mis beneficios",
                image = Res.drawable.gift_box,
                onClick = onDiscoverMyBenefitsClick
            )
        }
    }
}