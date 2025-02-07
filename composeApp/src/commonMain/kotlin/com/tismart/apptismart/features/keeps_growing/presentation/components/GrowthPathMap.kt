package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.arrow_up
import tismartproject.composeapp.generated.resources.growth_path_item1
import tismartproject.composeapp.generated.resources.growth_path_item2
import tismartproject.composeapp.generated.resources.growth_path_item3
import tismartproject.composeapp.generated.resources.growth_path_item4
import tismartproject.composeapp.generated.resources.growth_path_item5
import tismartproject.composeapp.generated.resources.growth_path_item6

@Composable
fun GrowthPathMap(
    onItemClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GrowthPathMapItem(
            icon = Res.drawable.growth_path_item1,
            title = "Líder Técnico",
            onItemClick = onItemClick
        )

        Icon(
            painter = painterResource(Res.drawable.arrow_up),
            contentDescription = null,
            tint = Color.White
        )

        GrowthPathMapItem(
            icon = Res.drawable.growth_path_item2,
            title = "Developer Senior",
            onItemClick = onItemClick
        )

        Icon(
            painter = painterResource(Res.drawable.arrow_up),
            contentDescription = null,
            tint = Color.White
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            GrowthPathMapItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.growth_path_item3,
                title = "Full Stack Developer",
                onItemClick = onItemClick
            )
            GrowthPathMapItem(
                modifier = Modifier.weight(1f),
                isSelected = true,
                icon = Res.drawable.growth_path_item4,
                title = "Developer Semi Senior",
                onItemClick = onItemClick
            )
            GrowthPathMapItem(
                modifier = Modifier.weight(1f),
                icon = Res.drawable.growth_path_item5,
                title = "Data Scientist",
                onItemClick = onItemClick
            )
        }

        Icon(
            painter = painterResource(Res.drawable.arrow_up),
            contentDescription = null,
            tint = Color.White
        )

        GrowthPathMapItem(
            iAmHere = true,
            icon = Res.drawable.growth_path_item6,
            title = "Developer Junior",
            onItemClick = onItemClick
        )
    }
}

@Composable
private fun GrowthPathMapItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    iAmHere: Boolean = false,
    icon: DrawableResource,
    title: String,
    onItemClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable(onClick = onItemClick).background(Color.Transparent),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .border(3.dp, if (iAmHere) PrimarioMedium else Color.Transparent, CircleShape)
                .shadow(elevation = if (iAmHere) 8.dp else 0.dp, shape = CircleShape, spotColor = Color.White)
                .clip(CircleShape)
                .background(if (isSelected) PrimarioMedium else NeutralLight),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = if (isSelected) Color.White else PrimarioMedium,
                modifier = Modifier.size(45.dp)
            )
        }

        Text(
            text = title,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}