package com.tismart.apptismart.news.presentation.news_list

import com.tismart.apptismart.core.presentation.UiText

sealed interface NewsListEvent {
    data class Error(val error: UiText) : NewsListEvent
}