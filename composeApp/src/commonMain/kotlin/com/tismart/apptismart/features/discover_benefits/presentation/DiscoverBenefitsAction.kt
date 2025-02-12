package com.tismart.apptismart.features.discover_benefits.presentation

sealed interface DiscoverBenefitsAction {
    data object OnProfileClick : DiscoverBenefitsAction
    data object OnNotificationsClick : DiscoverBenefitsAction
    data object OnBackClick : DiscoverBenefitsAction
    data object OnSearchForBenefitsClick : DiscoverBenefitsAction
    data class OnCategoryClick(val category: String) : DiscoverBenefitsAction
    data object OnSeeAllNewBenefitsClick : DiscoverBenefitsAction
    data object OnSeeAllMyFavoriteBenefitsClick : DiscoverBenefitsAction
    data object OnBenefitCardClick : DiscoverBenefitsAction
}