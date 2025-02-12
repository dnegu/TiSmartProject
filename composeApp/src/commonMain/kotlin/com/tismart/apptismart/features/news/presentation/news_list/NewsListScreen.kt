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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.components.TiSmartTopBar
import com.tismart.apptismart.features.news.presentation.news_list.components.NewsListCard
import com.tismart.apptismart.features.news.presentation.news_list.components.NewsListFilters
import com.tismart.apptismart.features.news.presentation.news_list.components.NewsListHeader
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NewsListScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onNewsDetailClick: () -> Unit,
    viewModel: NewsListViewModel = koinViewModel(),
) {
    NewsListScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                NewsListAction.OnProfileClick -> onProfileClick()
                NewsListAction.OnNotificationsClick -> onNotificationsClick()
                NewsListAction.OnBackClick -> onBackClick()
                NewsListAction.OnNewsDetailClick -> onNewsDetailClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
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
            notificationCount = 0,
            onMenuClick = { onAction(NewsListAction.OnProfileClick) },
            onNotificationsClick = { onAction(NewsListAction.OnNotificationsClick) }
        )
        NewsListHeader(
            onBackClick = { onAction(NewsListAction.OnBackClick) }
        )
        NewsListFilters(
            selectedFilter = state.selectedFilter,
            onSelectedFilter = { onAction(NewsListAction.OnSelectedFilter(it)) }
        )

        if (state.news.isEmpty()) {
            Text(
                text = "Por ahora, no hay noticias nuevas. ¡Vuelve pronto para mantenerte al día!",
                color = NeutralDark,
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(state.news) {
                    NewsListCard(
                        label = it.label,
                        title = it.title,
                        description = it.description,
                        supporting = it.supporting,
                        onClick = { onAction(NewsListAction.OnNewsDetailClick) }
                    )
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}