package com.tismart.apptismart.features.home.presentation

sealed interface HomeAction {
    data object OnProfileClick : HomeAction
    data object OnNotificationsClick : HomeAction
    data object OnSeeAllNewsClick: HomeAction
    data object OnKeepGrowingClick : HomeAction
    data object OnSearchForNewVacanciesClick : HomeAction
    data object OnEnhanceLearningClick : HomeAction
    data object OnDiscoverMyBenefitsClick : HomeAction
    data object OnTiSmartBuddyClick : HomeAction
    data object DismissTiSmartBuddyDialog : HomeAction
}