package com.tismart.apptismart.features.profile.presentation.my_data.components

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
fun ProfilePersonalInformation(
    firstName: String,
    lastName: String,
    email: String,
    address: String,
    phone: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "Información personal",
            color = SecundarioDark,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )

        ProfileTextField(
            label = "Nombre",
            value = firstName
        )

        ProfileTextField(
            label = "Apellido",
            value = lastName
        )

        ProfileTextField(
            label = "Correo",
            value = email
        )

        ProfileTextField(
            label = "Dirección",
            value = address,
            enabled = true
        )

        ProfileTextField(
            label = "Teléfono",
            value = phone,
            enabled = true
        )

    }
}