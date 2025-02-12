package com.tismart.apptismart.features.vacancy.presentation

sealed interface VacancyAction {
    data object OnProfileClick : VacancyAction
    data object OnNotificationsClick : VacancyAction
    data object OnBackClick : VacancyAction
    data object OnVacancyCardClick : VacancyAction
}