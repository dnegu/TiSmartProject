package com.tismart.apptismart.features.home.presentation

import com.tismart.apptismart.core.presentation.UiText

sealed interface HomeEvent {
    data class Error(val error: UiText) : HomeEvent
}