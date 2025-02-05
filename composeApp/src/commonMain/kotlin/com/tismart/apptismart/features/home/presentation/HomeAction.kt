package com.tismart.apptismart.features.home.presentation

sealed interface HomeAction {
    data object OnBackClick : HomeAction
    data object OnNotificationsClick : HomeAction
    data object OnKeepGrowingClick : HomeAction
    data object OnEnhanceLearningClick : HomeAction
    data object OnDiscoverNewVacanciesClick : HomeAction
    data object OnDiscoverMyBenefitsClick : HomeAction

}