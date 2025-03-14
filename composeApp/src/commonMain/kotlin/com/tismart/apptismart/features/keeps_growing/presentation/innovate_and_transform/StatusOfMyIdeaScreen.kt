package com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform

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
import com.tismart.apptismart.features.keeps_growing.presentation.components.StatusOfMyIdeaTracking
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathAction
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreen
import org.jetbrains.compose.resources.painterResource

@Composable
fun StatusOfMyIdeaScreenRoot(
    projectName: String,
    status: ProposalStatus,
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit
) {
    StatusOfMyIdeaScreen(
        projectName = projectName,
        status = status,
        onAction = { action ->
            when (action) {
                InnovateAndTransformAction.OnProfileClick -> onProfileClick()
                InnovateAndTransformAction.OnNotificationsClick -> onNotificationsClick()
                InnovateAndTransformAction.OnBackClick -> onBackClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun StatusOfMyIdeaScreen(
    projectName: String,
    status: ProposalStatus,
    onAction: (InnovateAndTransformAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Estado de mi idea",
            notificationCount = 0,
            onMenuClick = { onAction(InnovateAndTransformAction.OnProfileClick) },
            onNotificationsClick = { onAction(InnovateAndTransformAction.OnNotificationsClick) },
            onBackClick = { onAction(InnovateAndTransformAction.OnBackClick) }
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(30.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "¡Aquí puedes ver el progreso de tu idea de innovación y transformación! \uD83D\uDE80",
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
                    text = projectName,
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

            StatusOfMyIdeaTracking(
                projectStatus = status
            )
        }
    }
}