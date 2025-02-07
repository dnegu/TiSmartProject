package com.tismart.apptismart.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun TiSmartHeader(
    title: String? = null,
    onMenuClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SecundarioDark)
    ) {
        TiSmartTopBar(
            onMenuClick = onMenuClick,
            onNotificationsClick = onNotificationsClick
        )

        IconButton(
            onClick = onBackClick,
            modifier = Modifier.padding(start = 18.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.arrow_left),
                contentDescription = null,
                tint = PrimarioMedium
            )
        }

        if (title != null) {
            Text(
                text = title,
                modifier = Modifier.padding(start = 30.dp, bottom = 16.dp),
                color = Color.White,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}