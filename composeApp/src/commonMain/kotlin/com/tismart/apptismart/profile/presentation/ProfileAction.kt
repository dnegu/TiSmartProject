package com.tismart.apptismart.profile.presentation

sealed interface ProfileAction {
    data object OnBackClick : ProfileAction
    data object OnOtherClick : ProfileAction
}