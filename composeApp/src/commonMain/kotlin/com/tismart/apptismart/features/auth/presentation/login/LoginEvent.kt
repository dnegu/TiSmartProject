package com.tismart.apptismart.features.auth.presentation.login

import com.tismart.apptismart.core.presentation.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText) : LoginEvent
}