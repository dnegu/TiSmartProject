package com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform

sealed interface InnovateAndTransformAction {
    data object OnProfileClick : InnovateAndTransformAction
    data object OnNotificationsClick : InnovateAndTransformAction
    data object OnBackClick : InnovateAndTransformAction
    data class OnIdeaClick(val projectName: String, val status: ProposalStatus) : InnovateAndTransformAction
}