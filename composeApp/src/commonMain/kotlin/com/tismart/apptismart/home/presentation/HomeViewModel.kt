package com.tismart.apptismart.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tismart.apptismart.home.presentation.HomeAction
import com.tismart.apptismart.home.presentation.HomeState

class HomeViewModel(

) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun onAction(action: HomeAction) {

    }
}