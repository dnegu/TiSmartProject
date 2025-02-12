package com.tismart.apptismart.features.enhance_learning.presentation.tismart_university

sealed interface TiSmartLoversAction {
    data object OnProfileClick : TiSmartLoversAction
    data object OnNotificationsClick : TiSmartLoversAction
    data object OnBackClick : TiSmartLoversAction
    data object OnTiSmartLoversCourseCardClick : TiSmartLoversAction
}