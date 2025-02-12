package com.tismart.apptismart.features.vacancy.presentation

sealed interface VacancyDashboardAction {
    data object OnProfileClick : VacancyDashboardAction
    data object OnNotificationsClick : VacancyDashboardAction
    data object OnBackClick : VacancyDashboardAction
    data object OnSearchForVacanciesClick : VacancyDashboardAction
    data object OnMyApplicationsClick : VacancyDashboardAction
    data object OnNewVacanciesClick : VacancyDashboardAction
    data object OnSeeAllRecommendedVacanciesClick : VacancyDashboardAction
    data object OnRecommendedVacancyCardClick : VacancyDashboardAction
}