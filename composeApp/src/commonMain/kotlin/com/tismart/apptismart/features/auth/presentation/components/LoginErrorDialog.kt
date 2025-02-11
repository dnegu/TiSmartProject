package com.tismart.apptismart.features.auth.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.error_badge

@Composable
fun LoginUnexpectedErrorDialog(
    showDialog: Boolean,
    message: String,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onUnderstoodClick: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                modifier = modifier
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(Color.White)
                    .padding(30.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(Res.drawable.error_badge),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 12.dp).size(150.dp)
                )

                Text(
                    text = "Lo sentimos",
                    modifier = Modifier.padding(top = 5.dp),
                    color = NeutralDarkest,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = message,
                    color = NeutralDark,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodyMedium
                )

                Button(
                    onClick = onUnderstoodClick,
                    modifier = Modifier.fillMaxWidth().padding(top = 18.dp, bottom = 4.dp),
                    shape = MaterialTheme.shapes.extraSmall,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CriticalMedium,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Entendido",
                        modifier = Modifier.padding(vertical = 4.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}