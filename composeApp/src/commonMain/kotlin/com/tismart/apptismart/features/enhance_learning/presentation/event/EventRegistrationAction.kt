package com.tismart.apptismart.features.enhance_learning.presentation.event

sealed interface EventRegistrationAction {
    data object OnProfileClick : EventRegistrationAction
    data object OnNotificationsClick : EventRegistrationAction
    data object OnBackClick : EventRegistrationAction
    data object OnEnrollMeClick : EventRegistrationAction
}