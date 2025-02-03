package com.tismart.apptismart.news.presentation.news_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TiSmartTopBar
import com.tismart.apptismart.news.presentation.news_detail.components.NewsDetailHeader
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.arrow_left

@Composable
fun NewsDetailScreenRoot(
    viewModel: NewsDetailViewModel = koinViewModel(),
) {
    NewsDetailScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun NewsDetailScreen(
    state: NewsDetailState,
    onAction: (NewsDetailAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TiSmartTopBar(
            onBackClick = { onAction(NewsDetailAction.OnBackClick) },
            onNotificationsClick = { onAction(NewsDetailAction.OnNotificationsClick) }
        )

        NewsDetailHeader(
            onBackClick = { onAction(NewsDetailAction.OnBackClick) }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Image(
                painter = painterResource(state.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.large)
            )

            Text(
                text = state.title,
                color = SecundarioDark,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = state.description,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}