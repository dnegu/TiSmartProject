package com.tismart.apptismart.features.profile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.graduation_hat
import tismartproject.composeapp.generated.resources.profile_benefits
import tismartproject.composeapp.generated.resources.profile_new_vancancies
import tismartproject.composeapp.generated.resources.star_badge

@Composable
fun ProfileItemsCard(
    onKeepGrowingClick: () -> Unit,
    onEnhanceLearningClick: () -> Unit,
    onSearchForNewVacanciesClick: () -> Unit,
    onDiscoverMyBenefitsClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 36.dp)
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {
        ProfileItem(
            title = "Seguir creciendo",
            icon = Res.drawable.star_badge,
            onItemClick = onKeepGrowingClick
        )

        ProfileDivider()

        ProfileItem(
            title = "Potenciar mi aprendizaje",
            icon = Res.drawable.graduation_hat,
            onItemClick = onEnhanceLearningClick
        )

        ProfileDivider()

        ProfileItem(
            title = "Buscar nuevas vacantes",
            icon = Res.drawable.profile_new_vancancies,
            onItemClick = onSearchForNewVacanciesClick
        )

        ProfileDivider()

        ProfileItem(
            title = "Descubrir mis beneficios",
            icon = Res.drawable.profile_benefits,
            onItemClick = onDiscoverMyBenefitsClick
        )
    }
}

@Composable
private fun ProfileDivider() {
    HorizontalDivider(modifier = Modifier.padding(horizontal = 30.dp))
}

@Composable
private fun ProfileItem(
    title: String,
    icon: DrawableResource,
    onItemClick: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(text = title, fontWeight = FontWeight.Medium, style = MaterialTheme.typography.bodyMedium)
        },
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp).clickable(onClick = onItemClick),
        leadingContent = {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = Color.White
        )
    )
}