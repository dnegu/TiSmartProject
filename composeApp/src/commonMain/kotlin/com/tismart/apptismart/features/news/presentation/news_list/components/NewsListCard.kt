package com.tismart.apptismart.features.news.presentation.news_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.Amarillo
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.news_card

@Composable
fun NewsListCard(
    label: String?,
    title: String,
    description: String,
    supporting: String
) {
    ListItem(
        headlineContent = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = description,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Image(
                    painter = painterResource(Res.drawable.news_card),
                    contentDescription = "News card image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                        .size(70.dp)

                )
            }
        },
        modifier = Modifier
            .clickable(onClick = {})
            .padding(top = 12.dp),
        overlineContent = label?.let {
            {
                Text(
                    text = label,
                    color = NeutralDarkest,
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(Amarillo)
                        .padding(horizontal = 10.dp, vertical = 3.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 9.sp,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        },
        supportingContent = {
            Text(
                text = supporting,
                modifier = Modifier.padding(top = 8.dp),
                color = NeutralDarkMedium,
                style = MaterialTheme.typography.labelMedium
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = Color.White
        )
    )
}