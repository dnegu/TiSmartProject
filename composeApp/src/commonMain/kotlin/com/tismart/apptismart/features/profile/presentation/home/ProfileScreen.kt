package com.tismart.apptismart.features.profile.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.features.profile.presentation.components.ProfileHeader
import com.tismart.apptismart.features.profile.presentation.components.ProfileImageAndName
import com.tismart.apptismart.features.profile.presentation.components.ProfileItemsCard
import com.tismart.apptismart.features.profile.presentation.components.ProfileLogoutButton
import com.tismart.apptismart.features.profile.presentation.components.ProfileMyDataButton
import org.koin.compose.viewmodel.koinViewModel
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.profile_avatar

@Composable
fun ProfileScreenRoot(
    onCloseClick: () -> Unit,
    onMyDataClick: () -> Unit,
    onKeepGrowingClick: () -> Unit,
    onSearchForNewVacanciesClick: () -> Unit,
    onEnhanceLearningClick: () -> Unit,
    onDiscoverMyBenefitsClick: () -> Unit,
    onLogoutClick: () -> Unit,
    viewModel: ProfileViewModel = koinViewModel(),
) {
    ProfileScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                ProfileAction.OnCloseClick -> onCloseClick()
                ProfileAction.OnMyDataClick -> onMyDataClick()
                ProfileAction.OnKeepGrowingClick -> onKeepGrowingClick()
                ProfileAction.OnSearchForNewVacanciesClick -> onSearchForNewVacanciesClick()
                ProfileAction.OnEnhanceLearningClick -> onEnhanceLearningClick()
                ProfileAction.OnDiscoverMyBenefitsClick -> onDiscoverMyBenefitsClick()
                ProfileAction.OnLogoutClick -> onLogoutClick()
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun ProfileScreen(
    state: ProfileState,
    onAction: (ProfileAction) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        ProfileHeader(
            onCloseClick = { onAction(ProfileAction.OnCloseClick) }
        )

        ProfileImageAndName(
            image = Res.drawable.profile_avatar,
            name = "Ronald Andia"
        )

        ProfileMyDataButton(
            onClick = { onAction(ProfileAction.OnMyDataClick) }
        )

        ProfileItemsCard(
            onKeepGrowingClick = { onAction(ProfileAction.OnKeepGrowingClick) },
            onEnhanceLearningClick = { onAction(ProfileAction.OnEnhanceLearningClick) },
            onSearchForNewVacanciesClick = { onAction(ProfileAction.OnSearchForNewVacanciesClick) },
            onDiscoverMyBenefitsClick = { onAction(ProfileAction.OnDiscoverMyBenefitsClick) }
        )

        ProfileLogoutButton(
            onLogoutClick = { onAction(ProfileAction.OnLogoutClick) }
        )

    }
}