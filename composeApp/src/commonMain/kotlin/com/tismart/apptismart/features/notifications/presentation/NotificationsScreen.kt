package com.tismart.apptismart.features.notifications.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.features.notifications.presentation.components.NotificationListItem
import com.tismart.apptismart.features.notifications.presentation.components.NotificationsHeader
import com.tismart.apptismart.features.profile.presentation.edit_picture.EditProfilePictureAction
import com.tismart.apptismart.features.profile.presentation.edit_picture.EditProfilePictureScreen
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.notifications_icon

@Composable
fun NotificationsScreenRoot(
    onProfileClick: () -> Unit,
    onBackClick: () -> Unit
) {
    NotificationsScreen(
        onAction = { action ->
            when (action) {
                NotificationsAction.OnProfileClick -> onProfileClick()
                NotificationsAction.OnBackClick -> onBackClick()
            }
        }
    )
}

@Composable
fun NotificationsScreen(
    onAction: (NotificationsAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NotificationsHeader(
            onMenuClick = { onAction(NotificationsAction.OnProfileClick) },
            onBackClick = { onAction(NotificationsAction.OnBackClick) }
        )

        // TODO: When notifications are empty, add this:
        /*Text(
            text = "Por ahora, no hay notificaciones nuevas. ¡Vuelve pronto para mantenerte al día!",
            color = NeutralDark,
            modifier = Modifier.fillMaxWidth().padding(30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )*/

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f).background(Color.White),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(10) {
                NotificationListItem(
                    icon = Res.drawable.notifications_icon,
                    title = "Curso: Metodologías ágiles",
                    description = "¡Tenemos un nuevo evento sobre metodologías ágiles! Ingresa aquí para blal blalalallb blas",
                    date = "Hoy - 11:05 am"
                )
            }
        }
    }
}