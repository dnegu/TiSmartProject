package com.tismart.apptismart.profile.presentation.home

import com.tismart.apptismart.core.presentation.UiText

sealed interface ProfileEvent {
    data class Error(val error: UiText) : ProfileEvent
}