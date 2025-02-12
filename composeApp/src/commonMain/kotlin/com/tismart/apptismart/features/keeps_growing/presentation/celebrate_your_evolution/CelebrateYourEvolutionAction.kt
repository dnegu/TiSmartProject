package com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution

sealed interface CelebrateYourEvolutionAction {
    data object OnProfileClick : CelebrateYourEvolutionAction
    data object OnNotificationsClick : CelebrateYourEvolutionAction
    data object OnBackClick : CelebrateYourEvolutionAction
    data object OnColleagueCardClick : CelebrateYourEvolutionAction
}