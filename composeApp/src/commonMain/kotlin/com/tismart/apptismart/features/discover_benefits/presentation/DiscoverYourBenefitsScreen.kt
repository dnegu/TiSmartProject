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
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyAction

@Composable
fun DiscoverYourBenefitsScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onSearchForBenefitsClick: () -> Unit,
    onCategoryClick: (String) -> Unit,
    onSeeAllNewBenefitsClick: () -> Unit,
    onSeeAllMyFavoriteBenefitsClick: () -> Unit,
    onBenefitCardClick: () -> Unit
) {
    DiscoverYourBenefitsScreen(
        onAction = { action ->
            when (action) {
                DiscoverBenefitsAction.OnProfileClick -> onProfileClick()
                DiscoverBenefitsAction.OnNotificationsClick -> onNotificationsClick()
                DiscoverBenefitsAction.OnBackClick -> onBackClick()
                DiscoverBenefitsAction.OnSearchForBenefitsClick -> onSearchForBenefitsClick()
                is DiscoverBenefitsAction.OnCategoryClick -> onCategoryClick(action.category)
                DiscoverBenefitsAction.OnSeeAllNewBenefitsClick -> onSeeAllNewBenefitsClick()
                DiscoverBenefitsAction.OnSeeAllMyFavoriteBenefitsClick -> onSeeAllMyFavoriteBenefitsClick()
                DiscoverBenefitsAction.OnBenefitCardClick -> onBenefitCardClick()
            }
        }
    )
}

@Composable
fun DiscoverYourBenefitsScreen(
    onAction: (DiscoverBenefitsAction) -> Unit,
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
            notificationCount = 0,
            onMenuClick = { onAction(DiscoverBenefitsAction.OnProfileClick) },
            onNotificationsClick = { onAction(DiscoverBenefitsAction.OnNotificationsClick) },
            onBackClick = { onAction(DiscoverBenefitsAction.OnBackClick) }
        )

        DiscoverBenefitsSearchBar(
            text = "Buscar beneficios",
            onSearchBarClick = { onAction(DiscoverBenefitsAction.OnSearchForBenefitsClick) }
        )

        DiscoverYourBenefitsDisplayPager()

        DiscoverYourBenefitsCategoryList(
            onItemClick = { onAction(DiscoverBenefitsAction.OnCategoryClick(it)) }
        )

        DiscoverYourBenefitsListPager(
            title = "Nuevos",
            onSeeAllClick = { onAction(DiscoverBenefitsAction.OnSeeAllNewBenefitsClick) },
            onCardClick = { onAction(DiscoverBenefitsAction.OnBenefitCardClick) }
        )

        DiscoverYourBenefitsListPager(
            title = "Mis favoritos",
            onSeeAllClick = { onAction(DiscoverBenefitsAction.OnSeeAllMyFavoriteBenefitsClick) },
            onCardClick = { onAction(DiscoverBenefitsAction.OnBenefitCardClick) }
        )

        Spacer(modifier = Modifier.height(30.dp))
    }

    ActivateYourLocationDialog(
        showDialog = showLocationDialog,
        onDismiss = { showLocationDialog = false },
        onAllowLocationClick = { showLocationDialog = false }
    )
}