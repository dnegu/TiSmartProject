package com.tismart.apptismart.features.explore_courses.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.explore_new_courses_item1
import tismartproject.composeapp.generated.resources.explore_new_courses_item2
import tismartproject.composeapp.generated.resources.explore_new_courses_item3
import tismartproject.composeapp.generated.resources.explore_new_courses_item4
import tismartproject.composeapp.generated.resources.explore_new_courses_item5
import tismartproject.composeapp.generated.resources.explore_new_courses_item6

@Composable
fun ExploreNewCoursesGrid(
    onFrontendClick: () -> Unit,
    onBackendClick: () -> Unit,
    onFullstackClick: () -> Unit,
    onUxUiClick: () -> Unit,
    onMarketingClick: () -> Unit,
    onQaClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .background(SecundarioDark)
            .padding(horizontal = 30.dp)
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ExploreNewCoursesGridRow {
            ExploreNewCoursesGridItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.explore_new_courses_item1,
                title = "Frontend",
                onItemClick = onFrontendClick
            )
            ExploreNewCoursesGridItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.explore_new_courses_item2,
                title = "Backend",
                onItemClick = onBackendClick
            )
            ExploreNewCoursesGridItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.explore_new_courses_item3,
                title = "Fullstack",
                onItemClick = onFullstackClick
            )
        }

        ExploreNewCoursesGridRow {
            ExploreNewCoursesGridItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.explore_new_courses_item4,
                title = "UX/UI",
                onItemClick = onUxUiClick
            )
            ExploreNewCoursesGridItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.explore_new_courses_item5,
                title = "Marketing",
                onItemClick = onMarketingClick
            )
            ExploreNewCoursesGridItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.explore_new_courses_item6,
                title = "QA",
                onItemClick = onQaClick
            )
        }
    }
}

@Composable
private fun ExploreNewCoursesGridRow(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        content()
    }
}

@Composable
private fun ExploreNewCoursesGridItem(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    title: String,
    onItemClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable(onClick = onItemClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(HomeBackground)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
        Text(
            text = title,
            modifier = Modifier.padding(top = 2.dp),
            color = Color.White,
            style = MaterialTheme.typography.labelLarge
        )
    }
}