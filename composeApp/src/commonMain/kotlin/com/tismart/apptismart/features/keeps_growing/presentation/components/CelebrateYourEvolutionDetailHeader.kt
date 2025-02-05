package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.SecundarioLightest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.keeps_growing_card

@Composable
fun CelebrateYourEvolutionDetailHeader(
    image: DrawableResource,
    isFavorite: Boolean,
    onFavoriteClick: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(MaterialTheme.shapes.large)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.clickable(onClick = { onFavoriteClick(!isFavorite) }),
                tint = if (isFavorite) CriticalMedium else NeutralDarkest
            )
            Text(
                text = "11",
                color = NeutralDarkest,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Text(
            text = "UX Designer",
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .background(SecundarioLightest)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            color = SecundarioMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = "Carlina del Pilar",
            color = NeutralDarkest,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Por haber obtenido un buen rendimiento y haber brindado una buena propuesta, te felicitamos en este ascenso de Technical Leader a Support Analyst. \uD83D\uDE80\uD83E\uDD13\uD83D\uDC68\u200D\uD83D\uDCBB",
            color = NeutralDark,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}