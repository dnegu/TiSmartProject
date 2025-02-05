package com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.SecundarioLightest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import com.tismart.apptismart.features.keeps_growing.presentation.components.CelebrateYourEvolutionDetailHeader
import com.tismart.apptismart.features.keeps_growing.presentation.components.CelebrateYourEvolutionDetailPager
import com.tismart.apptismart.features.keeps_growing.presentation.components.KeepsGrowingHeader
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.keeps_growing_card

@Composable
fun CelebrateYourEvolutionDetailScreen() {
    val (isFavorite, onFavoriteClick) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        KeepsGrowingHeader(
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        CelebrateYourEvolutionDetailHeader(
            image = Res.drawable.keeps_growing_card,
            isFavorite = isFavorite,
            onFavoriteClick = onFavoriteClick
        )

        CelebrateYourEvolutionDetailPager()
    }
}