package com.tismart.apptismart.features.vacancy.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralMedium

@Composable
fun VacancyDetailHeader(
    name: String,
    location: String,
) {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Text(
            text = name,
            color = NeutralDarkest,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = location,
            color = NeutralDark,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.titleMedium
        )

        HorizontalDivider(modifier = Modifier.padding(top = 20.dp), color = NeutralMedium)
    }

}