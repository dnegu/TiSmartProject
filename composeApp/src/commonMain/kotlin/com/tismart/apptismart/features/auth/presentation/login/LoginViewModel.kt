package com.tismart.apptismart.features.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class LoginViewModel(

) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    init {
        combine(
            snapshotFlow { state.user },
            snapshotFlow { state.password }
        ) {
            user, password ->
            state = state.copy(
                canLogin = user.isNotEmpty() && password.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> {
                if (state.user != "47474747") {
                    state = state.copy(userErrorMessage = "El usuario ingresado es incorrecto")
                }

                if (state.password != "Admin123") {
                    state = state.copy(passwordErrorMessage = "La contraseña ingresada es incorrecta")
                }
            }
            is LoginAction.OnPasswordChange -> {
                state = state.copy(password = action.password)
            }
            LoginAction.OnTogglePasswordVisibility -> {
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)
            }
            is LoginAction.OnUserChange -> {
                state = state.copy(user = action.user)
            }
        }
    }
}