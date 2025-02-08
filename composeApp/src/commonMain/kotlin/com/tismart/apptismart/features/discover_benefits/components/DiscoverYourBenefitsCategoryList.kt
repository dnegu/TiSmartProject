package com.tismart.apptismart.features.discover_benefits.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.finanzas

@Composable
fun DiscoverYourBenefitsCategoryList() {
    Text(
        text = "Mis categorías",
        modifier = Modifier.padding(start = 30.dp, top = 36.dp, bottom = 16.dp),
        color = SecundarioDark,
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.titleLarge
    )

    LazyRow(
        contentPadding = PaddingValues(start = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(10) {
            DiscoverYourBenefitsCategoryListItem(
                icon = Res.drawable.finanzas,
                name = "Finanzas",
                onItemClick = {}
            )
        }
    }
}

@Composable
private fun DiscoverYourBenefitsCategoryListItem(
    icon: DrawableResource,
    name: String,
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(onClick = onItemClick),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .border(BorderStroke(width = 1.8.dp, color = NeutralLight), CircleShape)
                .clip(CircleShape)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = NeutralMedium,
                modifier = Modifier.size(34.dp)
            )
        }

        Text(
            text = name,
            color = NeutralDark,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.labelMedium
        )
    }
}