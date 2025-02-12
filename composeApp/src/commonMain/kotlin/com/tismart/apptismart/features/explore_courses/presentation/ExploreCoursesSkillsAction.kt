package com.tismart.apptismart.features.explore_courses.presentation

sealed interface ExploreCoursesSkillsAction {
    data object OnProfileClick : ExploreCoursesSkillsAction
    data object OnNotificationsClick : ExploreCoursesSkillsAction
    data object OnBackClick : ExploreCoursesSkillsAction
    data object OnCourseCardClick : ExploreCoursesSkillsAction
}