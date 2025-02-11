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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.explore_mentors_card

@Composable
fun ExploreMentorsPager(
    onSeeAllClick: () -> Unit
) {
    ExploreMentorsPagerHeader(
        onSeeAllClick = onSeeAllClick
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(start = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(5) {
            ExploreMentorsPagerItem(
                image = Res.drawable.explore_mentors_card,
                name = "Angela Ramos",
                description = "Experiencia de 3 años en UX, Angular e inteligencia.",
                label = "UX Designer",
                onCardClick = {}
            )
        }
    }
}

@Composable
private fun ExploreMentorsPagerItem(
    image: DrawableResource,
    name: String,
    description: String,
    label: String,
    onCardClick: () -> Unit
) {
    ElevatedCard(
        onClick = onCardClick,
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
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth().height(106.dp)
        )

        Column(
            modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = name,
                color = NeutralDarkest,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = description,
                color = NeutralDark,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = label,
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

@Composable
private fun ExploreMentorsPagerHeader(
    onSeeAllClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Nuestros mentores",
                color = SecundarioDark,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleMedium
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