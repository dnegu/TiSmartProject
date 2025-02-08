package com.tismart.apptismart.features.discover_benefits.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.components.ActivateYourLocationDialog
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsSearchBar
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverYourBenefitsCategoryList
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverYourBenefitsDisplayPager
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverYourBenefitsListPager

@Composable
fun DiscoverYourBenefitsScreen(
    onSearchBarClick: () -> Unit
) {
    var showLocationDialog by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Descubre tus beneficios",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        DiscoverBenefitsSearchBar(
            text = "Buscar beneficios",
            onSearchBarClick = onSearchBarClick
        )

        DiscoverYourBenefitsDisplayPager()

        DiscoverYourBenefitsCategoryList()

        DiscoverYourBenefitsListPager(
            title = "Nuevos",
            onSeeAllClick = {}
        )

        DiscoverYourBenefitsListPager(
            title = "Mis favoritos",
            onSeeAllClick = {}
        )

        Spacer(modifier = Modifier.height(30.dp))
    }

    ActivateYourLocationDialog(
        showDialog = showLocationDialog,
        onDismiss = { showLocationDialog = false },
        onAllowLocationClick = { showLocationDialog = false }
    )
}