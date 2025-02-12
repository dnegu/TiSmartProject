package com.tismart.apptismart.features.enhance_learning.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import com.tismart.apptismart.features.discover_benefits.presentation.components.EnhanceLearningListPagerItem
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.tismart_university_card

@Composable
fun EnhanceLearningListPager(
    title: String,
    onSeeAllClick: () -> Unit,
    onCardClick: () -> Unit
) {
    EnhanceLearningListPagerHeader(
        title = title,
        onSeeAllClick = onSeeAllClick
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(start = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(5) {
            EnhanceLearningListPagerItem(
                image = Res.drawable.tismart_university_card,
                name = "El arte de QA en tiempos actuales",
                description = "Testing de Software y automatización bla blallalal blasdsd bllb",
                author = "Ricardo Montaner",
                courseLevel = CourseLevel.INTERMEDIATE,
                onCardClick = onCardClick
            )
        }
    }
}

@Composable
private fun EnhanceLearningListPagerHeader(
    title: String,
    onSeeAllClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 30.dp, top = 28.dp, bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
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
}