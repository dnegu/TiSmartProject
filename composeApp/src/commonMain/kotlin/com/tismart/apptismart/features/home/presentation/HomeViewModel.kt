package com.tismart.apptismart.features.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel(

) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.OnTiSmartBuddyClick -> {
                state = state.copy(showTiSmartBuddyDialog = true)
            }
            HomeAction.DismissTiSmartBuddyDialog -> {
                state = state.copy(showTiSmartBuddyDialog = false)
            }
            else -> Unit
        }
    }
}