package com.tismart.apptismart.profile.presentation.edit_photo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.profile.presentation.components.ProfileHeader
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.profile_avatar

@Composable
fun ProfileEditPhotoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        ProfileHeader(
            title = "Editar foto de perfil",
            onCloseClick = {},
            onBackClick = {}
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(24.dp)
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.profile_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(width = 1.dp, color = PrimarioMedium)
            ) {
                Text(
                    text = "Selecciona desde tu dispositivo",
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = PrimarioMedium,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            TextButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Tomar una foto",
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = PrimarioMedium,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}