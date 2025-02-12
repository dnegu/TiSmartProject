package com.tismart.apptismart.features.profile.presentation.home

sealed interface ProfileAction {
    data object OnCloseClick : ProfileAction
    data object OnMyDataClick : ProfileAction
    data object OnKeepGrowingClick : ProfileAction
    data object OnSearchForNewVacanciesClick : ProfileAction
    data object OnEnhanceLearningClick : ProfileAction
    data object OnDiscoverMyBenefitsClick : ProfileAction
    data object OnLogoutClick : ProfileAction
}