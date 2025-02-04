package com.tismart.apptismart.profile.presentation.my_data.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark

@Composable
fun ProfileProfessionalInformation(
    area: String,
    position: String,
    supervisor: String,
    tiSmartBuddy: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "Información profesional",
            color = SecundarioDark,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )

        ProfileTextField(
            label = "Área",
            value = area
        )

        ProfileTextField(
            label = "Puesto actual",
            value = position
        )

        ProfileTextField(
            label = "Supervisor directo",
            value = supervisor
        )

        ProfileTextField(
            label = "Tismart Buddy",
            value = tiSmartBuddy
        )

    }
}