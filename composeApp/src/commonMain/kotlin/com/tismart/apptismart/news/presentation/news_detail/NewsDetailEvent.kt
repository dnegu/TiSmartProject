package com.tismart.apptismart.news.presentation.news_detail

import com.tismart.apptismart.core.presentation.UiText

sealed interface NewsDetailEvent {
    data class Error(val error: UiText) : NewsDetailEvent
}