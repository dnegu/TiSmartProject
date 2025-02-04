package com.tismart.apptismart.profile.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.arrow_left
import tismartproject.composeapp.generated.resources.profile_close

@Composable
fun ProfileHeader(
    onCloseClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecundarioDark)
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 6.dp)
    ) {
        IconButton(
            onClick = onCloseClick
        ) {
            Icon(
                painter = painterResource(Res.drawable.profile_close),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun ProfileHeader(
    title: String,
    onCloseClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecundarioDark)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
        IconButton(
            onClick = onCloseClick,
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.profile_close),
                contentDescription = null,
                tint = Color.White
            )
        }
        IconButton(
            onClick = onBackClick
        ) {
            Icon(
                painter = painterResource(Res.drawable.arrow_left),
                contentDescription = null,
                tint = PrimarioMedium
            )
        }
        Text(
            text = title,
            modifier = Modifier.padding(start = 12.dp, bottom = 8.dp),
            color = Color.White,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.titleLarge
        )
    }
}