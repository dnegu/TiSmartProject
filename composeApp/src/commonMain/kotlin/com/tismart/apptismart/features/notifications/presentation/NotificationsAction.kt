package com.tismart.apptismart.features.notifications.presentation

sealed interface NotificationsAction {
    data object OnProfileClick : NotificationsAction
    data object OnBackClick : NotificationsAction
}