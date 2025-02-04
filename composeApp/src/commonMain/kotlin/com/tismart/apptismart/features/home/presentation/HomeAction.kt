package com.tismart.apptismart.features.home.presentation

sealed interface HomeAction {
    data object OnBackClick : HomeAction
    data object OnNotificationsClick : HomeAction
}