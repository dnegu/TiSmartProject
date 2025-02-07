package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.OurMentorsListCard
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.explore_mentors_card

@Composable
fun OurMentorsListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TiSmartHeader(
            title = "Nuestros mentores",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(10) {
                OurMentorsListCard(
                    image = Res.drawable.explore_mentors_card,
                    onCardClick = {}
                )
            }
        }
    }
}