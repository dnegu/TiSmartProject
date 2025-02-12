package com.tismart.apptismart.features.news.presentation.news_detail

sealed interface NewsDetailAction {
    data object OnProfileClick : NewsDetailAction
    data object OnNotificationsClick : NewsDetailAction
    data object OnBackClick : NewsDetailAction
}