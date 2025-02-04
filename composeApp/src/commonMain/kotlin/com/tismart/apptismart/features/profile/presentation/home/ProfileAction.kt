package com.tismart.apptismart.features.profile.presentation.home

sealed interface ProfileAction {
    data object OnBackClick : ProfileAction
    data object OnOtherClick : ProfileAction
}