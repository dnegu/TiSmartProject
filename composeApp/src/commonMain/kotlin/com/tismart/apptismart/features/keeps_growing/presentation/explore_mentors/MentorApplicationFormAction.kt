package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

sealed interface MentorApplicationFormAction {
    data object OnProfileClick : MentorApplicationFormAction
    data object OnNotificationsClick : MentorApplicationFormAction
    data object OnBackClick : MentorApplicationFormAction
    data object DismissProposalSentDialog: MentorApplicationFormAction
}