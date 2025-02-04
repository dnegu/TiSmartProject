package com.tismart.apptismart.features.news.presentation.news_detail

sealed interface NewsDetailAction {
    data object OnBackClick : NewsDetailAction
    data object OnNotificationsClick : NewsDetailAction
}