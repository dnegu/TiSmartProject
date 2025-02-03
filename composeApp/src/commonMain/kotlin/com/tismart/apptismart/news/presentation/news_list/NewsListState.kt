package com.tismart.apptismart.news.presentation.news_list

import com.tismart.apptismart.news.News

data class NewsListState(
    val news: List<News> = emptyList(),
    val selectedFilter: NewsFilter = NewsFilter.TODAY
)

enum class NewsFilter {
    TODAY,
    YESTERDAY,
    LAST_WEEK,
}