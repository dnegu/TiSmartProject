package com.tismart.apptismart.features.discover_benefits.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.SecundarioLightest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.discover_benefits_card
import tismartproject.composeapp.generated.resources.discover_your_benefits_display
import tismartproject.composeapp.generated.resources.keeps_growing_card

@Composable
fun DiscoverYourBenefitsDisplayPager() {
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    Box {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
        ) {
            // Our page content
            Image(
                painter = painterResource(Res.drawable.discover_your_benefits_display),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        DiscoverYourBenefitsDisplayPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )

    }
}

@Composable
fun DiscoverYourBenefitsListPager(
    title: String,
    onSeeAllClick: () -> Unit
) {
    DiscoverYourBenefitsListPagerHeader(
        title = title,
        onSeeAllClick = onSeeAllClick
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(start = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(5) {
            DiscoverBenefitsListPagerItem(
                image = Res.drawable.discover_benefits_card,
                discount = 50,
                name = "La Tarumba",
                onCardClick = {}
            )
        }
    }
}

@Composable
private fun DiscoverYourBenefitsListPagerHeader(
    title: String,
    onSeeAllClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 30.dp, top = 28.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = SecundarioDark,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.headlineSmall
            )

            TextButton(
                onClick = onSeeAllClick,
                modifier = Modifier.padding(end = 10.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = PrimarioMedium
                )
            ) {
                Text(
                    text = "Ver todo",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }
    }
}

@Composable
private fun DiscoverYourBenefitsDisplayPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) NeutralDark else Color.White
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )
        }
    }
}