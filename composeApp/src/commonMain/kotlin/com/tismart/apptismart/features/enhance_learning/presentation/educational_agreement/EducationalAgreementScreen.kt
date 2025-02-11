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

@Composable
fun EducationalAgreementScreen() {
    var showProposalSentDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Convenio educativo",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
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
                onHistoryItemClick = {}
            )
        }
    }

    ApplicationSubmittedDialog(
        showDialog = showProposalSentDialog,
        onDismiss = { showProposalSentDialog = false },
        onUnderstoodClick = { showProposalSentDialog = false }
    )
}