package com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.InnovateAndTransformProposalSentDialog
import com.tismart.apptismart.features.keeps_growing.presentation.components.InnovateAndTransformTab
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.download

@Composable
fun InnovateAndTransformScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onIdeaClick: (String, ProposalStatus) -> Unit
) {
    InnovateAndTransformScreen(
        onAction = { action ->
            when (action) {
                InnovateAndTransformAction.OnProfileClick -> onProfileClick()
                InnovateAndTransformAction.OnNotificationsClick -> onNotificationsClick()
                InnovateAndTransformAction.OnBackClick -> onBackClick()
                is InnovateAndTransformAction.OnIdeaClick -> onIdeaClick(action.projectName, action.status)
            }
        }
    )
}

@Composable
fun InnovateAndTransformScreen(
    onAction: (InnovateAndTransformAction) -> Unit
) {
    var isFileUpload: Boolean? by remember { mutableStateOf(null) }
    var showProposalSentDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Innova y transforma",
            notificationCount = 0,
            onMenuClick = { onAction(InnovateAndTransformAction.OnProfileClick) },
            onNotificationsClick = { onAction(InnovateAndTransformAction.OnNotificationsClick) },
            onBackClick = { onAction(InnovateAndTransformAction.OnBackClick) }
        )

        Column(
            modifier = Modifier.padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "¿Tienes una idea que puede transformar la empresa? \uD83D\uDCA1",
                color = NeutralDarkest,
                style = MaterialTheme.typography.bodyMedium
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = HomeBackground
                ),
            ) {
                Column(
                    modifier = Modifier.padding(32.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Descarga la plantilla y envía tu idea para evaluarla y ponerla en marcha.",
                        color = NeutralDarkest,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    TextButton(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = PrimarioMedium
                        ),
                        contentPadding = ButtonDefaults.TextButtonWithIconContentPadding
                    ) {
                        Text(
                            text = "Descargar plantilla",
                            modifier = Modifier,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(Res.drawable.download),
                            contentDescription = null
                        )
                    }
                }

            }

            InnovateAndTransformTab(
                isFileUpload = isFileUpload,
                onFileUploadClick = { isFileUpload = null },
                onFileDeleteClick = { isFileUpload = null },
                onProposalSentClick = { showProposalSentDialog = true },
                onHistoryItemClick = { projectName, status ->
                    onAction(InnovateAndTransformAction.OnIdeaClick(projectName, status))
                }
            )
        }
    }

    InnovateAndTransformProposalSentDialog(
        showDialog = showProposalSentDialog,
        onDismiss = { showProposalSentDialog = false },
        onUnderstoodClick = { showProposalSentDialog = false }
    )
}