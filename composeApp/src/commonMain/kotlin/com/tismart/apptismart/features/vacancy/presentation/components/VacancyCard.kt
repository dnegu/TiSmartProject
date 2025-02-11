package com.tismart.apptismart.features.vacancy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.Amarillo
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import com.tismart.apptismart.features.vacancy.presentation.VacancyStatus

@Composable
fun VacancyCard(
    name: String,
    isNew: Boolean = false,
    location: String,
    date: String,
    onCardClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onCardClick)
            .fillMaxWidth()
            .padding(bottom = 18.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = name,
                modifier = Modifier.weight(1f, false),
                color = NeutralDarkest,
                fontSize = 21.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge
            )

            if (isNew) {
                Text(
                    text = "Nuevo",
                    modifier = Modifier
                        .wrapContentWidth()
//                        .width(65.dp)
//                        .weight(.24f, false)
                        .clip(MaterialTheme.shapes.small)
                        .background(Amarillo)
                        .padding(horizontal = 8.dp, vertical = 3.dp),
                    color = NeutralDarkest,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = location,
                color = Color(0xFF666666),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge
            )

            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = null,
                tint = NeutralDarkMedium
            )
        }

        Text(
            text = "Fecha límite de solicitud:",
            color = SecundarioMedium,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = date,
            color = SecundarioMedium,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.labelMedium
        )

    }
}

@Composable
fun VacancyCard(
    name: String,
    vacancyStatus: VacancyStatus,
    jobNumber: String,
    announcementDate: String,
    receptionDate: String,
    onCardClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onCardClick)
            .fillMaxWidth()
            .padding(bottom = 18.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = name,
                modifier = Modifier.weight(1f),
                color = NeutralDarkest,
                fontSize = 21.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = vacancyStatus.label,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(vacancyStatus.backgroundColor)
                    .padding(horizontal = 10.dp, vertical = 3.dp),
                color = vacancyStatus.textColor,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.labelLarge
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = jobNumber,
                color = Color(0xFF666666),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge
            )

            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = null,
                tint = NeutralDarkMedium
            )
        }

        Row {
           Column(
               modifier = Modifier.weight(1f)
           ) {
               Text(
                   text = "Fecha de anuncio:",
                   color = SecundarioMedium,
                   fontSize = 13.sp,
                   fontWeight = FontWeight.Normal,
                   style = MaterialTheme.typography.labelMedium
               )
               Text(
                   text = announcementDate,
                   color = SecundarioMedium,
                   fontSize = 13.sp,
                   fontWeight = FontWeight.SemiBold,
                   style = MaterialTheme.typography.labelMedium
               )
           }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Fecha de recepción:",
                    color = SecundarioMedium,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = receptionDate,
                    color = SecundarioMedium,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}