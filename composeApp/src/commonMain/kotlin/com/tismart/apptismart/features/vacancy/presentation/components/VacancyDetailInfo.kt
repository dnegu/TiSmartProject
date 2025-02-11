package com.tismart.apptismart.features.vacancy.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.person
import tismartproject.composeapp.generated.resources.share_close
import tismartproject.composeapp.generated.resources.share_copy

@Composable
fun VacancyDetailInfo(
    jobNumber: String,
    announcementDate: String,
    applicationDeadline: String,
    leader: String,
    isShared: Boolean,
    onApplyNowClick: () -> Unit,
    onShareClick: () -> Unit,
    onShareCloseClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp)
    ) {
        Text(
            text = jobNumber,
            color = Color(0xFF676767),
            style = MaterialTheme.typography.titleSmall
        )

        Row(
            modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
        ) {
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
                    text = "Fecha límite de solicitud:",
                    color = SecundarioMedium,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = applicationDeadline,
                    color = SecundarioMedium,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Row(
            modifier = Modifier.height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            Button(
                onClick = onApplyNowClick,
                modifier = Modifier.weight(1f).fillMaxHeight(),
                shape = MaterialTheme.shapes.extraSmall,
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimarioMedium,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Aplicar ahora",
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            OutlinedButton(
                onClick = onShareClick,
                modifier = Modifier.weight(1f).fillMaxHeight(),
                shape = MaterialTheme.shapes.extraSmall,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = PrimarioMedium
                ),
                border = BorderStroke(width = 1.dp, color = PrimarioMedium)
            ) {
                Text(
                    text = "Compartir",
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

    Box(
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        ListItem(
            headlineContent = {
                Column(
                    modifier = Modifier.padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Lider del proceso",
                        color = NeutralDarkest,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = leader,
                        color = NeutralDark
                    )
                }
            },
            modifier = Modifier.padding(horizontal = 30.dp)
                .clip(MaterialTheme.shapes.medium)
                .alpha(if (isShared) 0f else 1f),
            leadingContent = {
                Icon(
                    painter = painterResource(Res.drawable.person),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            },
            colors = ListItemDefaults.colors(
                containerColor = HomeBackground
            )
        )

        ElevatedCard(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 18.dp)
                .alpha(if (isShared) 1f else 0f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 3.dp
            ),
            shape = MaterialTheme.shapes.medium
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.share_copy),
                    contentDescription = null,
                    tint = NeutralDark
                )
                Text(
                    text = "Enlace copiado al portapapeles para que puedas compartirlo",
                    modifier = Modifier.weight(1f),
                    color = NeutralDarkest,
                    style = MaterialTheme.typography.bodyLarge
                )
                Icon(
                    painter = painterResource(Res.drawable.share_close),
                    contentDescription = null,
                    tint = NeutralDark,
                    modifier = Modifier.clickable(onClick = onShareCloseClick)
                )
            }
        }
    }

}