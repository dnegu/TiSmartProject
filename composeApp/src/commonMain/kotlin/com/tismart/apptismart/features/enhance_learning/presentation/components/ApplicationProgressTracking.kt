package com.tismart.apptismart.features.enhance_learning.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.PrimarioLightest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.RegistrationStatus

@Composable
fun ApplicationProgressTracking(
    agreementStatus: RegistrationStatus
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(IntrinsicSize.Max)
    ) {
        VerticalDivider(
            modifier = Modifier.fillMaxHeight().padding(start = 16.dp),
            thickness = 1.6.dp,
            color = NeutralMedium
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            ApplicationProgressTrackingItem(
                agreementStatus = agreementStatus,
                status = RegistrationStatus.SENT
            )

            ApplicationProgressTrackingItem(
                agreementStatus = agreementStatus,
                status = RegistrationStatus.UNDER_REVIEW
            )

            ApplicationProgressTrackingItem(
                agreementStatus = agreementStatus,
                status = RegistrationStatus.APPROVED
            )

            ApplicationProgressTrackingItem(
                agreementStatus = agreementStatus,
                status = RegistrationStatus.NOT_APPROVED
            )
        }
    }
}

@Composable
private fun ApplicationProgressTrackingItem(
    agreementStatus: RegistrationStatus,
    status: RegistrationStatus
) {
    val backgroundColor = if (agreementStatus == status) {
        PrimarioMedium
    } else {
        if (agreementStatus.ordinal > status.ordinal) {
            PrimarioMedium
        } else {
            PrimarioLightest
        }
    }
    val bubbleTextColor = if (agreementStatus.ordinal >= status.ordinal) {
        Color.White
    } else {
        PrimarioMedium
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(Color.White)
                .padding(4.dp)
                .clip(CircleShape)
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${status.ordinal + 1}",
                color = bubbleTextColor,
                style = MaterialTheme.typography.labelLarge
            )
        }

        Column {
            Text(
                text = status.title,
                modifier = Modifier.padding(top = 4.dp),
                color = if (agreementStatus.ordinal >= status.ordinal) NeutralDarkest else NeutralMedium,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge
            )

            if (agreementStatus.ordinal == status.ordinal) {
                Text(
                    text = "Tu solicitud se encuentra en revisión. Recibirás una notificación cuando pase a la siguiente etapa.",
                    modifier = Modifier.padding(top = 8.dp),
                    color = NeutralDark,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}