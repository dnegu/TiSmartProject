package com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement

sealed interface EducationalAgreementAction {
    data object OnProfileClick : EducationalAgreementAction
    data object OnNotificationsClick : EducationalAgreementAction
    data object OnBackClick : EducationalAgreementAction
    data class OnApplicationClick(val agreementName: String, val status: RegistrationStatus) : EducationalAgreementAction
}