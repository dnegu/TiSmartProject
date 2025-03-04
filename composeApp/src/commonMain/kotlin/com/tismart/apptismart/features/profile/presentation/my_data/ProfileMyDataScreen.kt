package com.tismart.apptismart.features.profile.presentation.my_data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.features.profile.presentation.components.ProfileHeader
import com.tismart.apptismart.features.profile.presentation.home.ProfileAction
import com.tismart.apptismart.features.profile.presentation.home.ProfileScreen
import com.tismart.apptismart.features.profile.presentation.home.ProfileViewModel
import com.tismart.apptismart.features.profile.presentation.my_data.components.ProfileMyDataImageAndName
import com.tismart.apptismart.features.profile.presentation.my_data.components.ProfilePersonalInformation
import com.tismart.apptismart.features.profile.presentation.my_data.components.ProfileProfessionalInformation
import org.koin.compose.viewmodel.koinViewModel
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.profile_avatar

@Composable
fun ProfileMyDataScreenRoot(
    onCloseClick: () -> Unit,
    onBackClick: () -> Unit,
    onEditProfilePictureClick: () -> Unit,
) {
    ProfileMyDataScreen(
        onAction = { action ->
            when (action) {
                ProfileMyDataAction.OnCloseClick -> onCloseClick()
                ProfileMyDataAction.OnBackClick -> onBackClick()
                ProfileMyDataAction.OnEditProfilePictureClick -> onEditProfilePictureClick()
            }
        }
    )
}

@Composable
fun ProfileMyDataScreen(
    onAction: (ProfileMyDataAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 32.dp)
    ) {
        ProfileHeader(
            title = "Mis datos",
            onCloseClick = { onAction(ProfileMyDataAction.OnCloseClick) },
            onBackClick = { onAction(ProfileMyDataAction.OnBackClick) }
        )

        ProfileMyDataImageAndName(
            image = Res.drawable.profile_avatar,
            name = "Ronald Andia",
            onEditClick = { onAction(ProfileMyDataAction.OnEditProfilePictureClick) }
        )

        ProfilePersonalInformation(
            firstName = "Ronald",
            lastName = "Andia Gamarra",
            email = "ronald.andia@pucp.pe",
            address = "Av. El sol 456 - Chorrillos",
            phone = "977 876 567",
            addressErrorMessage = null,
            phoneErrorMessage = null
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProfileProfessionalInformation(
            area = "Servicios - cliente",
            position = "UX Design",
            supervisor = "Comunidador",
            tiSmartBuddy = "Micaela Rodriguez"
        )
    }
}