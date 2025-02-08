package com.tismart.apptismart.features.discover_benefits.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.search

@Composable
fun DiscoverBenefitsSearchBar(
    text: String,
    onSearchBarClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(SecundarioDark)
            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().clickable(onClick = onSearchBarClick),
            value = text,
            onValueChange = {},
            readOnly = true,
            enabled = false,
            textStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.search),
                    contentDescription = "Search",
                    tint = Color(0xFFB7BABC)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = Color(0xFFB7BABC),
                disabledBorderColor = Color(0xFFD9DADB),
                disabledTrailingIconColor = Color(0xFFB7BABC),
                disabledContainerColor = Color.White
            )
        )
    }
}