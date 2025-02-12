package com.tismart.apptismart.features.enhance_learning.presentation.home

sealed interface EnhanceLearningAction {
    data object OnProfileClick : EnhanceLearningAction
    data object OnNotificationsClick : EnhanceLearningAction
    data object OnBackClick : EnhanceLearningAction
    data object OnExploreNewCoursesClick : EnhanceLearningAction
    data object OnTiSmartUniversityClick : EnhanceLearningAction
    data object OnEducationalAgreementClick : EnhanceLearningAction
}