package com.tismart.apptismart.features.discover_benefits.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.components.ClaimBenefitDialog
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsCategoryDetailBody
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsCategoryDetailHeader
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsCategoryDetailPager
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.discover_benefits_card

@Composable
fun DiscoverBenefitsCategoryDetailScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onBenefitCardClick: () -> Unit
) {
    DiscoverBenefitsCategoryDetailScreen(
        onAction = { action ->
            when (action) {
                DiscoverBenefitsAction.OnProfileClick -> onProfileClick()
                DiscoverBenefitsAction.OnNotificationsClick -> onNotificationsClick()
                DiscoverBenefitsAction.OnBackClick -> onBackClick()
                DiscoverBenefitsAction.OnBenefitCardClick -> onBenefitCardClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun DiscoverBenefitsCategoryDetailScreen(
    onAction: (DiscoverBenefitsAction) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            notificationCount = 0,
            onMenuClick = { onAction(DiscoverBenefitsAction.OnProfileClick) },
            onNotificationsClick = { onAction(DiscoverBenefitsAction.OnNotificationsClick) },
            onBackClick = { onAction(DiscoverBenefitsAction.OnBackClick) }
        )

        DiscoverBenefitsCategoryDetailHeader(
            image = Res.drawable.discover_benefits_card,
            discount = 50,
            name = "La Tarumba",
            description = "Aprovecha esta oportunidad única para vivir tus eventos favoritos pagando la mitad. Con nuestro beneficio exclusivo en Teleticket."
        )

        DiscoverBenefitsCategoryDetailBody(
            conditions = listOf(
                "Aprovecha S/300 de descuento en cursos y programas de Crehana y aprende nuevas habilidades que transformarán tu carrera. Paga en cuotas sin intereses con tu tarjeta de crédito Visa BCP.",
                "Válido para cursos, diplomados y certificaciones en nuestra plataforma online.",
            ),
            onGoToBenefitClick = { showDialog = true }
        )

        DiscoverBenefitsCategoryDetailPager(
            onCardClick = { onAction(DiscoverBenefitsAction.OnBenefitCardClick) }
        )
    }

    ClaimBenefitDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onGoToBenefitClick = { showDialog = false }
    )
}