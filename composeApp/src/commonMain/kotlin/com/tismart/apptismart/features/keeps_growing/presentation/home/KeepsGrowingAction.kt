package com.tismart.apptismart.features.keeps_growing.presentation.home

sealed interface KeepsGrowingAction {
    data object OnProfileClick : KeepsGrowingAction
    data object OnNotificationsClick : KeepsGrowingAction
    data object OnBackClick : KeepsGrowingAction
    data object OnSeeAllColleaguesClick : KeepsGrowingAction
    data object OnGrowthPathClick : KeepsGrowingAction
    data object OnInnovateAndTransformClick : KeepsGrowingAction
    data object OnExploreMentorsClick : KeepsGrowingAction
}