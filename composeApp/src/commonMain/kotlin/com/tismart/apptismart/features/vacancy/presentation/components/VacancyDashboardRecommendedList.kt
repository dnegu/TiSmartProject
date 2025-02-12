package com.tismart.apptismart.features.vacancy.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark

@Composable
fun VacancyDashboardRecommendedList(
    onSeeAllClick: () -> Unit,
    onCardClick: () -> Unit
) {

    VacancyDashboardRecommendedListHeader(
        onSeeAllClick = onSeeAllClick
    )

    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        VacancyCard(
            name = "Diseñador UX/UI (PR)",
            isNew = false,
            location = "Lima, Perú. (En remoto)",
            date = "12/04/24",
            onCardClick = onCardClick
        )
        HorizontalDivider(color = NeutralLight)

        VacancyCard(
            name = "DevOps Engineer",
            isNew = false,
            location = "Lima, Perú. (En remoto)",
            date = "12/04/24",
            onCardClick = onCardClick
        )
        HorizontalDivider(color = NeutralLight)

        VacancyCard(
            name = "Service Designer",
            isNew = true,
            location = "Lima, Perú. (En remoto)",
            date = "12/04/24",
            onCardClick = onCardClick
        )
        HorizontalDivider(color = NeutralLight)
    }
}

@Composable
private fun VacancyDashboardRecommendedListHeader(
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 30.dp, top = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Recomendados para ti",
            modifier = Modifier.weight(1f),
            color = SecundarioDark,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )

        TextButton(
            onClick = onSeeAllClick,
            modifier = Modifier.padding(end = 10.dp),
            colors = ButtonDefaults.textButtonColors(
                contentColor = PrimarioMedium
            )
        ) {
            Text(
                text = "Ver todo",
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}