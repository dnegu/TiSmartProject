package com.tismart.apptismart.features.news.presentation.news_list

import com.tismart.apptismart.features.news.News

data class NewsListState(
    val news: List<News> = emptyList(),
    val selectedFilter: NewsFilter = NewsFilter.TODAY
)

enum class NewsFilter {
    TODAY,
    YESTERDAY,
    LAST_WEEK,
}