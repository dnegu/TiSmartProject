package com.tismart.apptismart.features.profile.presentation.edit_picture

sealed interface EditProfilePictureAction {
    data object OnCloseClick : EditProfilePictureAction
    data object OnBackClick : EditProfilePictureAction
}