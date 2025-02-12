package com.tismart.apptismart.features.enhance_learning.presentation.event

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.components.TISmartActionButton
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.enhance_learning.presentation.components.EventRegistrationFormEnrollmentReason
import com.tismart.apptismart.features.enhance_learning.presentation.components.EventRegistrationFormEvent
import com.tismart.apptismart.features.enhance_learning.presentation.components.SuccessfulEnrollmentDialog
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormArea
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormCurrentPosition

@Composable
fun EventRegistrationFormScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit
) {
    EventRegistrationFormScreen(
        onAction = { action ->
            when (action) {
                EventRegistrationAction.OnProfileClick -> onProfileClick()
                EventRegistrationAction.OnNotificationsClick -> onNotificationsClick()
                EventRegistrationAction.OnBackClick -> onBackClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun EventRegistrationFormScreen(
    onAction: (EventRegistrationAction) -> Unit
) {
    val options = listOf("Staff administrativo", "Servicio al cliente")
    var area by remember { mutableStateOf("") }
    var currentPosition by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    var showSuccessfulEnrollmentDialog by remember { mutableStateOf(false) }

    val eventRegistrationFormError by remember { mutableStateOf(EventRegistrationFormError()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Formulario de inscripción",
            notificationCount = 0,
            onMenuClick = { onAction(EventRegistrationAction.OnProfileClick) },
            onNotificationsClick = { onAction(EventRegistrationAction.OnNotificationsClick) },
            onBackClick = { onAction(EventRegistrationAction.OnBackClick) }
        )

        Column(
            modifier = Modifier.padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Completa el formulario para inscribirte al evento.",
                color = NeutralDarkest,
                style = MaterialTheme.typography.bodyMedium
            )

            EventRegistrationFormEvent(
                event = "Ethical Hacking"
            )

            ApplicationFormArea(
                area = area,
                options = options,
                isError = eventRegistrationFormError.area,
                onAreaChange = { area = it }
            )

            ApplicationFormCurrentPosition(
                currentPosition = currentPosition,
                isError = eventRegistrationFormError.currentPosition,
                onCurrentPositionChange = { currentPosition = it }
            )

            EventRegistrationFormEnrollmentReason(
                reason = reason,
                isError = eventRegistrationFormError.reason,
                onReasonChange = { reason = it }
            )

            TISmartActionButton(
                text = "Inscribirme",
                isLoading = false,
                enabled = area.isNotEmpty() && currentPosition.isNotEmpty() && reason.isNotEmpty(),
                onClick = { showSuccessfulEnrollmentDialog = true }
            )
        }
    }

    SuccessfulEnrollmentDialog(
        showDialog = showSuccessfulEnrollmentDialog,
        onDismiss = { showSuccessfulEnrollmentDialog = false },
        onUnderstoodClick = { showSuccessfulEnrollmentDialog = false }
    )
}