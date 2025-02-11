package com.tismart.apptismart.features.vacancy.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.SecundarioDark

@Composable
fun VacancyDetailBody(
    description: String,
    challenges: List<String>,
    competencies: List<String>,
    benefits: List<String>
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp).padding(bottom = 48.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        VacancyDetailBodyItem(
            title = "Descripción del puesto",
            text = description
        )

        VacancyDetailBodyItem(
            title = "Desafíos del puesto",
            text = challenges
        )

        VacancyDetailBodyItem(
            title = "¿Qué necesitamos de ti?",
            text = competencies
        )

        VacancyDetailBodyItem(
            title = "¿Qué te ofrecemos en TISmart?",
            text = benefits
        )
    }
}

@Composable
private fun VacancyDetailBodyItem(
    modifier: Modifier = Modifier,
    title: String,
    text: String
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            color = SecundarioDark,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = text,
            color = NeutralDark,
            fontSize = 15.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun VacancyDetailBodyItem(
    modifier: Modifier = Modifier,
    title: String,
    text: List<String>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            color = SecundarioDark,
            style = MaterialTheme.typography.titleLarge
        )
        Column {
            text.forEach { t ->
                Text(
                    text = "• $t",
                    color = NeutralDark,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}