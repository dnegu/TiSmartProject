package com.tismart.apptismart.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.ic_bell
import tismartproject.composeapp.generated.resources.ic_menu
import tismartproject.composeapp.generated.resources.logo_topbar

@Composable
fun TiSmartTopBar(
    onMenuClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(SecundarioDark)
            .statusBarsPadding()
            .padding(horizontal = 18.dp, vertical = 8.dp)
    ) {
        IconButton(
            onClick = onMenuClick,
        ) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_menu),
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        Image(
            painter = painterResource(resource = Res.drawable.logo_topbar),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.width(100.dp)
        )

        IconButton(
            onClick = onNotificationsClick
        ) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_bell),
                contentDescription = "Notifications",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun TiSmartTopBar(
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(SecundarioDark)
            .statusBarsPadding()
            .padding(horizontal = 18.dp, vertical = 8.dp)
    ) {
        IconButton(
            onClick = onMenuClick,
        ) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_menu),
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        Image(
            painter = painterResource(resource = Res.drawable.logo_topbar),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.width(100.dp)
        )

        Box(modifier = Modifier.size(24.dp))
    }
}