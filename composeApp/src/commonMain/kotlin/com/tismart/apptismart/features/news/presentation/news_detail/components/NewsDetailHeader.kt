package com.tismart.apptismart.features.news.presentation.news_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.arrow_left

@Composable
fun NewsDetailHeader(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecundarioDark)
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        IconButton(
            onClick = onBackClick
        ) {
            Image(
                painter = painterResource(Res.drawable.arrow_left),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.width(24.dp)
            )
        }
    }
}