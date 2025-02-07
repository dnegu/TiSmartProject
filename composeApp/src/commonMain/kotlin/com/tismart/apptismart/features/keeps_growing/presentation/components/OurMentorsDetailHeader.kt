package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.SecundarioLightest
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun OurMentorsDetailHeader(
    image: DrawableResource,
    label: String,
    name: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(MaterialTheme.shapes.large)
        )

        Text(
            text = label,
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .background(SecundarioLightest)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            color = SecundarioMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = name,
            color = NeutralDarkest,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = description,
            color = NeutralDark,
            fontSize = 15.sp,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}