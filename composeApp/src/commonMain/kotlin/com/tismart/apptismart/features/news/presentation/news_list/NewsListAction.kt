package com.tismart.apptismart.features.news.presentation.news_list

sealed interface NewsListAction {
    data object OnProfileClick : NewsListAction
    data object OnNotificationsClick : NewsListAction
    data object OnBackClick : NewsListAction
    data class OnSelectedFilter(val filter: NewsFilter) : NewsListAction
    data object OnNewsDetailClick : NewsListAction
}