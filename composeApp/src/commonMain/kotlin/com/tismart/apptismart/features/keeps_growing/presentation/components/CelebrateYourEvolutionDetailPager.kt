package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.SecundarioLightest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.keeps_growing_card

@Composable
fun CelebrateYourEvolutionDetailPager() {
    Column(
        modifier = Modifier.background(HomeBackground).padding(vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Descubre los logros de tus compañeros",
            modifier = Modifier.padding(horizontal = 30.dp),
            color = SecundarioDark,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(start = 30.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(5) {
                ElevatedCard(
                    onClick = {},
                    modifier = Modifier.width(150.dp),
                    shape = MaterialTheme.shapes.small,
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 2.dp
                    )
                ) {
                    Image(
                        painter = painterResource(Res.drawable.keeps_growing_card),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().height(106.dp)
                    )

                    Column(
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = null,
                                tint = NeutralDarkest
                            )
                            Text(
                                text = "10",
                                color = NeutralDarkest,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                        Text(
                            text = "UX Designer",
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.extraSmall)
                                .background(SecundarioLightest)
                                .padding(horizontal = 10.dp, vertical = 2.dp),
                            color = SecundarioMedium,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            text = "Carlina del Pilar",
                            color = NeutralDarkest,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = "Por tu ascenso de Technical Leader a Subllalas blalbl blalsd bbasd vf dsada",
                            color = NeutralDark,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}