package com.tismart.apptismart.features.explore_courses.presentation

sealed interface ExploreNewCoursesAction {
    data object OnProfileClick : ExploreNewCoursesAction
    data object OnNotificationsClick : ExploreNewCoursesAction
    data object OnBackClick : ExploreNewCoursesAction
    data object OnSearchForCoursesClick : ExploreNewCoursesAction
    data class OnSkillClick(val skill: String) : ExploreNewCoursesAction
    data object OnSeeAllRecommendedCoursesClick : ExploreNewCoursesAction
    data object OnRecommendedCourseCardClick : ExploreNewCoursesAction
}