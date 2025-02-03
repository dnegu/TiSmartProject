package com.tismart.apptismart.features.home.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    val name = MutableStateFlow("")
    fun setName(value: String) {
        name.update { value }
    }
}