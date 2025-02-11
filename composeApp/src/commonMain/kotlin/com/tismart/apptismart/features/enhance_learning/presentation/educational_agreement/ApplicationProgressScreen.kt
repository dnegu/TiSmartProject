package com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.enhance_learning.presentation.components.ApplicationProgressTracking
import org.jetbrains.compose.resources.painterResource

@Composable
fun ApplicationProgressScreen(
    agreementName: String,
    status: RegistrationStatus
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Progreso de solicitud",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "¡Aquí puedes ver el progreso de tu solicitud de Convenio Educativo!",
                color = NeutralDarkest,
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .background(HomeBackground)
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = agreementName,
                    color = NeutralDark,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyLarge
                )

                Row(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                        .background(status.backgroundColor)
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(status.icon),
                        contentDescription = null,
                        tint = status.textColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = status.label,
                        color = status.textColor,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }

            ApplicationProgressTracking(
                agreementStatus = RegistrationStatus.UNDER_REVIEW
            )
        }
    }
}