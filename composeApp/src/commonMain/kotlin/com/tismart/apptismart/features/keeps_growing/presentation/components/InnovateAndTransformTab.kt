package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TISmartActionButton
import com.tismart.apptismart.core.presentation.dashedBorder
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.ProposalStatus
import org.jetbrains.compose.resources.painterResource

@Composable
fun InnovateAndTransformTab(
    isFileUpload: Boolean?,
    onFileUploadClick: () -> Unit,
    onFileDeleteClick: () -> Unit,
    onProposalSentClick: () -> Unit,
    onHistoryItemClick: (String, ProposalStatus) -> Unit
) {
    Text(
        text = "Ideas que transforman",
        modifier = Modifier.padding(top = 12.dp),
        color = SecundarioDark,
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.headlineSmall
    )

    var state by remember { mutableStateOf(0) }
    val titles = listOf("Subir idea", "Historial")
    TabRow(
        selectedTabIndex = state,
        containerColor = Color.White,
        contentColor = PrimarioMedium,
        divider = { HorizontalDivider(thickness = 6.dp, color = NeutralLight) },
        indicator = @Composable { tabPositions ->
            if (state < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    height = 6.dp,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[state]),
                    color = PrimarioMedium
                )
            }
        }
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = state == index,
                onClick = { state = index },
                text = {
                    Text(
                        text = title, maxLines = 2, overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                unselectedContentColor = NeutralDarkMedium
            )
        }
    }

    when (state) {
        0 -> SubmitIdeaTab(
            isFileUpload = isFileUpload,
            onFileUploadClick = onFileUploadClick,
            onFileDeleteClick = onFileDeleteClick,
            onProposalSentClick = onProposalSentClick
        )

        1 -> HistoryTab(
            onItemClick = onHistoryItemClick
        )
    }
}

@Composable
private fun SubmitIdeaTab(
    isFileUpload: Boolean?,
    onFileUploadClick: () -> Unit,
    onFileDeleteClick: () -> Unit,
    onProposalSentClick: () -> Unit
) {
    Text(
        text = "Sube aquí tu idea. Podrás darle seguimiento y ver su estado a medida que avanza.",
        color = NeutralDarkest,
        style = MaterialTheme.typography.bodyMedium
    )

    if (isFileUpload == true) {
        var fileTitle by remember { mutableStateOf("") }
        var fileTitleError by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = NeutralLight, shape = MaterialTheme.shapes.large)
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Plantilla.pdf",
                    color = NeutralDarkest,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "388 kb",
                    color = NeutralDarkest,
                )
            }

            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = null,
                modifier = Modifier.size(36.dp).clickable(onClick = onFileDeleteClick),
                tint = NeutralDark
            )
        }

        Column(
            modifier = Modifier.padding(top = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Agrega un título a este archivo",
                color = NeutralDarkMedium,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge
            )
            OutlinedTextField(
                value = fileTitle,
                onValueChange = { fileTitle = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = NeutralDarkest),
                isError = fileTitleError,
                supportingText = if (fileTitleError) {
                    { Text(text = "Campo incompleto", color = CriticalMedium, fontWeight = FontWeight.SemiBold) }
                } else {
                    null
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = NeutralMedium,
                    focusedBorderColor = NeutralMedium,
                    errorBorderColor = CriticalMedium,
                    errorTextColor = NeutralDarkest
                )
            )
        }

        TISmartActionButton(
            text = "Enviar mi propuesta",
            isLoading = false,
            enabled = fileTitle.isNotBlank(),
            onClick = onProposalSentClick
        )
    } else {
        val borderColor = if (isFileUpload == null) NeutralMedium else CriticalMedium
        Column(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .dashedBorder(color = borderColor, shape = MaterialTheme.shapes.large)
                .clickable(onClick = onFileUploadClick)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.AddCircle,
                contentDescription = null,
                tint = PrimarioMedium,
                modifier = Modifier.padding(bottom = 8.dp).size(64.dp)
            )

            Text(
                text = "Seleccionar archivo",
                color = NeutralDarkest,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "PDF o DOCX (hasta 2 GB)",
                color = NeutralDarkMedium,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        if (isFileUpload == false) {
            Text(
                text = "Formato inválido, solo se permite pdf o docx",
                modifier = Modifier.offset(y = (-8).dp),
                color = CriticalMedium,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}

@Composable
private fun HistoryTab(
    onItemClick: (String, ProposalStatus) -> Unit
) {
    LazyColumn(
        modifier = Modifier.heightIn(max = 500.dp)
    ) {
        item {
            ProposalHistoryItem(
                projectName = "Mi proyecto",
                status = ProposalStatus.SENT,
                onItemClick = { onItemClick("Mi proyecto", ProposalStatus.SENT) }
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                projectName = "Mi proyecto",
                status = ProposalStatus.UNDER_REVIEW,
                onItemClick = { onItemClick("Mi proyecto", ProposalStatus.UNDER_REVIEW) }
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                projectName = "Mi proyecto",
                status = ProposalStatus.APPROVED,
                onItemClick = { onItemClick("Mi proyecto", ProposalStatus.APPROVED) }
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                projectName = "Mi proyecto",
                status = ProposalStatus.IN_PROGRESS,
                onItemClick = { onItemClick("Mi proyecto", ProposalStatus.IN_PROGRESS) }
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                projectName = "Mi proyecto",
                status = ProposalStatus.COMPLETED,
                onItemClick = { onItemClick("Mi proyecto", ProposalStatus.COMPLETED) }
            )
        }
    }
}

@Composable
private fun ProposalHistoryItem(
    projectName: String,
    status: ProposalStatus,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = projectName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = status.label,
                    color = status.textColor,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = null,
                tint = NeutralDarkMedium
            )
        }
    }
}