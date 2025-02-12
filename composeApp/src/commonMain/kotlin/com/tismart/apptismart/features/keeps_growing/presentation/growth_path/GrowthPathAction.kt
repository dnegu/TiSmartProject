package com.tismart.apptismart.features.keeps_growing.presentation.growth_path

sealed interface GrowthPathAction {
    data object OnProfileClick : GrowthPathAction
    data object OnNotificationsClick : GrowthPathAction
    data object OnBackClick : GrowthPathAction
    data object OnItemClick : GrowthPathAction
}