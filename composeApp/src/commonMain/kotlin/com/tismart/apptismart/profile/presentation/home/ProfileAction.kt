package com.tismart.apptismart.profile.presentation.home

sealed interface ProfileAction {
    data object OnBackClick : ProfileAction
    data object OnOtherClick : ProfileAction
}