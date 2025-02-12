package com.tismart.apptismart.features.discover_benefits.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.SecundarioDark
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.discover_benefits_card

@Composable
fun DiscoverBenefitsCategoryDetailPager(
    onCardClick: () -> Unit
) {
    Column(
        modifier = Modifier.background(HomeBackground).padding(vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Te podría interesar",
            modifier = Modifier.padding(horizontal = 30.dp),
            color = SecundarioDark,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(start = 30.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(5) {
                DiscoverBenefitsListPagerItem(
                    image = Res.drawable.discover_benefits_card,
                    discount = 50,
                    name = "Teatro La Plaza",
                    onCardClick = onCardClick
                )
            }
        }
    }
}