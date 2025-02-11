package com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement

data class RegistrationFormError(
    val course: Boolean = false,
    val reason: Boolean = false,
    val link: Boolean = false,
    val termsAndConditions: Boolean = false
)