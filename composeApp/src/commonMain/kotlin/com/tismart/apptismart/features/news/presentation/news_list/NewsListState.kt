package com.tismart.apptismart.features.news.presentation.news_list

import com.tismart.apptismart.features.news.News

data class NewsListState(
    val news: List<News> = (1..10).map {
        News(
            label = if (it % 2 == 0) "IMPORTANTE" else null,
            title = "Teletrabajo del 11 al 13 de noviembre",
            description = "Gobierno dispone clases virtuales y teletrabajo del 11 al 13 de noviembre blabla bla",
            supporting = "Hace 50 min"
        )
    },
    val selectedFilter: NewsFilter = NewsFilter.TODAY
)

enum class NewsFilter {
    TODAY,
    YESTERDAY,
    LAST_WEEK,
}