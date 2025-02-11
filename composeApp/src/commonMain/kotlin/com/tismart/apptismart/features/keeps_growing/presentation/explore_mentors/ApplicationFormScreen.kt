package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

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
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormArea
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormAttachCV
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormCurrentPosition
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormMotivation
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormProposalSentDialog
import com.tismart.apptismart.features.keeps_growing.presentation.components.ApplicationFormYourExperience
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.ApplicationFormError

@Composable
fun ApplicationFormScreen() {
    val options = listOf("Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread")
    var area by remember { mutableStateOf("") }
    var currentPosition by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var motivation by remember { mutableStateOf("") }
    var cv by remember { mutableStateOf("") }
    var showProposalSentDialog by remember { mutableStateOf(false) }

    val applicationFormError by remember { mutableStateOf(ApplicationFormError()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Formulario de postulación",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        Column(
            modifier = Modifier.padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Completa el formulario para inscribirte y solicitar un mentor.",
                color = NeutralDarkest,
                style = MaterialTheme.typography.bodyMedium
            )

            ApplicationFormArea(
                area = area,
                options = options,
                isError = applicationFormError.area,
                onAreaChange = { area = it }
            )

            ApplicationFormCurrentPosition(
                currentPosition = currentPosition,
                isError = applicationFormError.currentPosition,
                onCurrentPositionChange = { currentPosition = it }
            )

            ApplicationFormYourExperience(
                experience = experience,
                isError = applicationFormError.experience,
                onExperienceChange = { experience = it }
            )

            ApplicationFormMotivation(
                motivation = motivation,
                isError = applicationFormError.motivation,
                onMotivationChange = { motivation = it }
            )

            ApplicationFormAttachCV(
                cv = cv,
                isError = applicationFormError.cv,
                onAttachCVClick = { cv = "cv.marketing/pdf" }
            )

            TISmartActionButton(
                text = "Postular",
                isLoading = false,
                enabled = area.isNotEmpty() && currentPosition.isNotEmpty() && experience.isNotEmpty() && motivation.isNotEmpty() && cv.isNotEmpty(),
                onClick = { showProposalSentDialog = true }
            )
        }
    }

    ApplicationFormProposalSentDialog(
        showDialog = showProposalSentDialog,
        onDismiss = { showProposalSentDialog = false },
        onUnderstoodClick = { showProposalSentDialog = false }
    )
}