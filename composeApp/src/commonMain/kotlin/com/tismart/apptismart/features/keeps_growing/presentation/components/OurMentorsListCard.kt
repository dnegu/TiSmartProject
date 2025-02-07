package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.SecundarioLightest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun OurMentorsListCard(
    image: DrawableResource,
    onCardClick: () -> Unit
) {
    ElevatedCard(
        onClick = onCardClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        ),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 115.dp, height = 130.dp)
            )

            Column(
                modifier = Modifier.weight(1f).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Angela Ramos",
                    color = NeutralDarkest,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Experiencia de 3 años en UX, Angular e inteligencia.",
                    color = NeutralDark,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                )
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
            }
        }
    }
}