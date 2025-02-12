package com.tismart.apptismart.features.keeps_growing.presentation.growth_path

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionAction
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.components.GrowthPathMap
import com.tismart.apptismart.features.keeps_growing.presentation.components.GrowthPathMesh

@Composable
fun GrowthPathScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onItemClick: () -> Unit
) {
    GrowthPathScreen(
        onAction = { action ->
            when (action) {
                GrowthPathAction.OnProfileClick -> onProfileClick()
                GrowthPathAction.OnNotificationsClick -> onNotificationsClick()
                GrowthPathAction.OnBackClick -> onBackClick()
                GrowthPathAction.OnItemClick -> onItemClick()
            }
        }
    )
}

@Composable
fun GrowthPathScreen(
    onAction: (GrowthPathAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SecundarioDark)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Tu ruta de crecimiento",
            notificationCount = 0,
            onMenuClick = { onAction(GrowthPathAction.OnProfileClick) },
            onNotificationsClick = { onAction(GrowthPathAction.OnNotificationsClick) },
            onBackClick = { onAction(GrowthPathAction.OnBackClick) }
        )

        Text(
            text = "Explora los puestos a los que podrías llegar y los cursos que te acercarán a tus metas.\n\n¡Tu camino de crecimiento comienza aquí! \uD83D\uDE80",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 30.dp).padding(bottom = 16.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        GrowthPathMap(
            onItemClick = { onAction(GrowthPathAction.OnItemClick) }
        )

        GrowthPathMesh()
    }
}