package com.tismart.apptismart.features.enhance_learning.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun EventRegistrationBody(
    image: DrawableResource,
    speaker: String,
    date: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(text = "Ponente:", color = NeutralDark, fontWeight = FontWeight.Normal, style = MaterialTheme.typography.bodyLarge)
                Text(text = speaker, color = NeutralDarkest, fontWeight = FontWeight.Medium, style = MaterialTheme.typography.titleLarge)
            }
        }

        Column {
            Text(text = "Fecha", color = NeutralDark)
            Text(text = date, color = NeutralDarkest, fontWeight = FontWeight.Medium)
        }

        Text(text = description, color = NeutralDark)
    }
}