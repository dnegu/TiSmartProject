package com.tismart.apptismart.features.auth.presentation.login

data class LoginState(
    val user: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val canLogin: Boolean = false,
    val isLoggingIn: Boolean = false,
    val userErrorMessage: String? = null,
    val passwordErrorMessage: String? = null
)