package com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement

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
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.enhance_learning.presentation.components.ApplicationSubmittedDialog
import com.tismart.apptismart.features.enhance_learning.presentation.components.EducationalAgreementTab
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyAction

@Composable
fun EducationalAgreementScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onApplicationClick: (String, RegistrationStatus) -> Unit
) {
    EducationalAgreementScreen(
        onAction = { action ->
            when (action) {
                EducationalAgreementAction.OnProfileClick -> onProfileClick()
                EducationalAgreementAction.OnNotificationsClick -> onNotificationsClick()
                EducationalAgreementAction.OnBackClick -> onBackClick()
                is EducationalAgreementAction.OnApplicationClick -> onApplicationClick(action.agreementName, action.status)
            }
        }
    )
}

@Composable
fun EducationalAgreementScreen(
    onAction: (EducationalAgreementAction) -> Unit
) {
    var showProposalSentDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Convenio educativo",
            notificationCount = 0,
            onMenuClick = { onAction(EducationalAgreementAction.OnProfileClick) },
            onNotificationsClick = { onAction(EducationalAgreementAction.OnNotificationsClick) },
            onBackClick = { onAction(EducationalAgreementAction.OnBackClick) }
        )

        Column(
            modifier = Modifier.padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "En TISmart, apostamos por el aprendizaje y la innovación.\n\n¡Aplica a nuestro Convenio Educativo y mejora tu perfil con un curso o certificación! \uD83D\uDE80",
                color = NeutralDarkest,
                style = MaterialTheme.typography.bodyMedium
            )

            EducationalAgreementTab(
                onSubmitApplicationClick = { showProposalSentDialog = true },
                onHistoryItemClick = { agreementName, status ->
                    onAction(EducationalAgreementAction.OnApplicationClick(agreementName, status))
                }
            )
        }
    }

    ApplicationSubmittedDialog(
        showDialog = showProposalSentDialog,
        onDismiss = { showProposalSentDialog = false },
        onUnderstoodClick = { showProposalSentDialog = false }
    )
}