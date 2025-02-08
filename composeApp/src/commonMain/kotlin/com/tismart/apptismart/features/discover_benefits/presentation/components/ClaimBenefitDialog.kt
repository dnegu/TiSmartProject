package com.tismart.apptismart.features.discover_benefits.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.laptop_gift

@Composable
fun ClaimBenefitDialog(
    showDialog: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onGoToBenefitClick: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                modifier = modifier
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier.padding(top = 4.dp, end = 4.dp).align(Alignment.End)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Close icon"
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Image(
                        painter = painterResource(Res.drawable.laptop_gift),
                        contentDescription = "Laptop gift",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(100.dp)
                    )

                    Text(
                        text = "¡Estas a un paso!",
                        modifier = Modifier.padding(vertical = 14.dp),
                        color = NeutralDarkest,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "Te llevaremos a una página externa donde encontrarás lo que necesitas.",
                        color = NeutralDark,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Button(
                        onClick = onGoToBenefitClick,
                        modifier = Modifier.fillMaxWidth().padding(top = 18.dp),
                        shape = MaterialTheme.shapes.extraSmall,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimarioMedium,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Sí, ir a Bee Beneficios",
                            modifier = Modifier.padding(vertical = 4.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 36.dp),
                        shape = MaterialTheme.shapes.extraSmall,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.White,
                            contentColor = PrimarioMedium
                        ),
                        border = BorderStroke(width = 1.dp, color = PrimarioMedium)
                    ) {
                        Text(
                            text = "Volver",
                            modifier = Modifier.padding(vertical = 4.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}