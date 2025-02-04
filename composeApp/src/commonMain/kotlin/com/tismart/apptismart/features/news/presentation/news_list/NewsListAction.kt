package com.tismart.apptismart.features.news.presentation.news_list

sealed interface NewsListAction {
    data object OnBackClick : NewsListAction
    data object OnNotificationsClick : NewsListAction
    data class OnSelectedFilter(val filter: NewsFilter) : NewsListAction
}