package com.tismart.apptismart.features.news.presentation.news_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.features.news.presentation.news_list.components.NewsListCard
import com.tismart.apptismart.features.news.presentation.news_list.components.NewsListFilters
import com.tismart.apptismart.features.news.presentation.news_list.components.NewsListHeader
import com.tismart.apptismart.core.presentation.components.TiSmartTopBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NewsListScreenRoot(
    viewModel: NewsListViewModel = koinViewModel(),
) {
    NewsListScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun NewsListScreen(
    state: NewsListState,
    onAction: (NewsListAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartTopBar(
            onBackClick = { onAction(NewsListAction.OnBackClick) },
            onNotificationsClick = { onAction(NewsListAction.OnNotificationsClick) }
        )
        NewsListHeader(
            onBackClick = { onAction(NewsListAction.OnBackClick) }
        )
        NewsListFilters(
            selectedFilter = state.selectedFilter,
            onSelectedFilter = { onAction(NewsListAction.OnSelectedFilter(it)) }
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(state.news) {
                NewsListCard(
                    label = it.label,
                    title = it.title,
                    description = it.description,
                    supporting = it.supporting
                )
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}