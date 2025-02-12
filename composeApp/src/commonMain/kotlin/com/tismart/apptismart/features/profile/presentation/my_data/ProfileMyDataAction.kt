package com.tismart.apptismart.features.profile.presentation.my_data

sealed interface ProfileMyDataAction {
    data object OnCloseClick : ProfileMyDataAction
    data object OnBackClick : ProfileMyDataAction
    data object OnEditProfilePictureClick : ProfileMyDataAction
}