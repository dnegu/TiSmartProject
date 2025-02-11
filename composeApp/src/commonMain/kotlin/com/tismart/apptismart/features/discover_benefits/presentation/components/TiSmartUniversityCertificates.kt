package com.tismart.apptismart.features.discover_benefits.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.download

@Composable
fun TiSmartUniversityCertificates(
    onDownloadClick: () -> Unit
) {
    Text(
        text = "Descarga tus certificados",
        modifier = Modifier.padding(start = 30.dp, top = 30.dp),
        color = SecundarioDark,
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.headlineSmall
    )

    LazyColumn(
        modifier = Modifier.heightIn(max = 500.dp),
        contentPadding = PaddingValues(30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(6) {
            Row(
                modifier = Modifier
                    .clickable(onClick = onDownloadClick)
                    .fillMaxWidth()
                    .border(width = 1.2.dp, color = NeutralLight, MaterialTheme.shapes.medium)
                    .padding(18.dp),
                horizontalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                Text(
                    text = "Taller de liderazgo",
                    color = NeutralDarkest,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    painter = painterResource(Res.drawable.download),
                    contentDescription = null,
                    tint = PrimarioMedium
                )
            }
        }
    }
}