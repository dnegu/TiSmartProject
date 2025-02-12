package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

sealed interface ExploreMentorsAction {
    data object OnProfileClick : ExploreMentorsAction
    data object OnNotificationsClick : ExploreMentorsAction
    data object OnBackClick : ExploreMentorsAction
    data object OnSeeAllMentorsClick : ExploreMentorsAction
    data object OnMentorCardClick : ExploreMentorsAction
    data object OnApplyHereClick : ExploreMentorsAction
}