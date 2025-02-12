package com.tismart.apptismart.features.enhance_learning.presentation.tismart_university

sealed interface TiSmartUniversityAction {
    data object OnProfileClick : TiSmartUniversityAction
    data object OnNotificationsClick : TiSmartUniversityAction
    data object OnBackClick : TiSmartUniversityAction
    data object OnEventClick : TiSmartUniversityAction
    data object OnSeeAllTiSmartLoversCoursesClick : TiSmartUniversityAction
    data object OnTiSmartLoversCourseCardClick : TiSmartUniversityAction
}