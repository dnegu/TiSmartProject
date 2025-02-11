package com.tismart.apptismart.features.enhance_learning.presentation.components

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
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun EventRegistrationHeader(
    image: DrawableResource,
    name: String,
    courseLevel: CourseLevel
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp).padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
                .clip(MaterialTheme.shapes.extraLarge)
        )

        Text(
            text = name,
            color = NeutralDarkest,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = courseLevel.title,
            modifier = Modifier
                .padding(bottom = 2.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(courseLevel.backgroundColor)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            color = courseLevel.textColor,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}