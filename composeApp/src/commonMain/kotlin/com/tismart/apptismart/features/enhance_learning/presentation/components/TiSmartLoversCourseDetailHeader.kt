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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun TiSmartLoversCourseDetailHeader(
    image: DrawableResource,
    name: String,
    description: String,
    author: String,
    courseLevel: CourseLevel
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp).padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(MaterialTheme.shapes.extraLarge)
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


        Text(
            text = author,
            color = NeutralDarkMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = courseLevel.title,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 2.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(courseLevel.backgroundColor)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            color = courseLevel.textColor,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.labelLarge
        )
    }
}