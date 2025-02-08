package com.tismart.apptismart.features.discover_benefits.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.star

@Composable
fun DiscoverBenefitsCategoryDetailBody(
    conditions: List<String>,
    onGoToBenefitClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp).padding(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Como usar tu beneficio",
            color = NeutralDarkest,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.headlineSmall
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            conditions.forEach { condition ->
                Text(
                    text = "• $condition",
                    color = NeutralDark,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
            shape = MaterialTheme.shapes.large,
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF3EDFF)
            )
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Para usar este beneficio:",
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.star),
                        contentDescription = null,
                        tint = SecundarioMedium
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = "Codigo de descuento:",
                            fontWeight = FontWeight.Light,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "CREHANA 100",
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }

        Button(
            onClick = onGoToBenefitClick,
            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimarioMedium,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Ir a Bee Beneficios",
                modifier = Modifier.padding(vertical = 6.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}