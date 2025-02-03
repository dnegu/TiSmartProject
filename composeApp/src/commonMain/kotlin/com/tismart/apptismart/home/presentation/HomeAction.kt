package com.tismart.apptismart.home.presentation

sealed interface HomeAction {
    data object OnBackClick : HomeAction
    data object OnNotificationsClick : HomeAction
}