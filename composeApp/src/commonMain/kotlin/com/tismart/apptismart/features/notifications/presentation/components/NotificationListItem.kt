package com.tismart.apptismart.features.notifications.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun NotificationListItem(
    icon: DrawableResource,
    title: String,
    description: String,
    date: String
) {
    ListItem(
        headlineContent = {
            Row {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = SecundarioDark,
                    modifier = Modifier.padding(top = 12.dp, end = 16.dp).size(24.dp)
                )
                Column {
                    Text(
                        text = title,
                        color = NeutralDarkest,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = description,
                        modifier = Modifier.padding(top = 2.dp, bottom = 4.dp),
                        color = NeutralDark,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = date,
                        color = NeutralMedium,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        },
        colors = ListItemDefaults.colors(
            containerColor = Color.White
        )
    )
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        thickness = 1.5.dp,
        color = NeutralLight
    )
}