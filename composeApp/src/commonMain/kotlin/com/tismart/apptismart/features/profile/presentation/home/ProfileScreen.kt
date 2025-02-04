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
    viewModel: ProfileViewModel = koinViewModel(),
) {
    ProfileScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
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
            onCloseClick = {}
        )

        ProfileImageAndName(
            image = Res.drawable.profile_avatar,
            name = "Ronald Andia"
        )

        ProfileMyDataButton(
            onClick = {}
        )

        ProfileItemsCard(
            onItem1Click = {},
            onItem2Click = {},
            onItem3Click = {},
            onItem4Click = {}
        )

        ProfileLogoutButton(
            onLogoutClick = {}
        )

    }

}