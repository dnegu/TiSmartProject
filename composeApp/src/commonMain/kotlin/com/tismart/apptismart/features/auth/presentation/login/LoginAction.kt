package com.tismart.apptismart.features.auth.presentation.login

sealed interface LoginAction {
    data object OnTogglePasswordVisibility: LoginAction
    data object OnLoginClick: LoginAction
    data class OnUserChange(val user: String): LoginAction
    data class OnPasswordChange(val password: String): LoginAction
}