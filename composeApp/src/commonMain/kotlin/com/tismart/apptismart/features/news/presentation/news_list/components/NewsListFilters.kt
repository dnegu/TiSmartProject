package com.tismart.apptismart.features.news.presentation.news_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.SecundarioLight
import com.tismart.apptismart.features.news.presentation.news_list.NewsFilter
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.document

@Composable
fun NewsListFilters(
    selectedFilter: NewsFilter,
    onSelectedFilter: (NewsFilter) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecundarioDark)
            .padding(
                start = 24.dp,
                bottom = 30.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            NewsListFilterChip(
                label = "Hoy",
                selected = selectedFilter == NewsFilter.TODAY,
                onClick = { onSelectedFilter(NewsFilter.TODAY) }
            )
        }

        item {
            NewsListFilterChip(
                label = "Ayer",
                selected = selectedFilter == NewsFilter.YESTERDAY,
                onClick = { onSelectedFilter(NewsFilter.YESTERDAY) }
            )
        }

        item {
            NewsListFilterChip(
                label = "La semana pasada",
                selected = selectedFilter == NewsFilter.LAST_WEEK,
                onClick = { onSelectedFilter(NewsFilter.LAST_WEEK) }
            )
        }
    }
}

@Composable
private fun NewsListFilterChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = {
            Text(
                text = label,
                modifier = Modifier.padding(vertical = 10.dp),
                color = if (selected) {
                    SecundarioDark
                } else {
                    Color.White
                }
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(Res.drawable.document),
                contentDescription = "Document icon",
                modifier = Modifier.size(FilterChipDefaults.IconSize),
                tint = if (selected) {
                    SecundarioLight
                } else {
                    Color.White
                }
            )
        },
        shape = CircleShape,
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = selected,
            borderColor = SecundarioLight,
            selectedBorderColor = SecundarioLight,
            borderWidth = 1.5.dp,
            selectedBorderWidth = 1.5.dp
        )
    )
}