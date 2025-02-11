package com.tismart.apptismart.features.profile.presentation.my_data.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralMedium

@Composable
fun ProfileTextField(
    label: String,
    value: String,
    enabled: Boolean = false,
    errorMessage: String? = null,
    onValueChange: (String) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = label,
            color = NeutralDarkMedium,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleMedium
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(color = NeutralDark, fontWeight = FontWeight.Medium),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = NeutralMedium,
                focusedBorderColor = NeutralMedium,
                disabledBorderColor = NeutralMedium,
                disabledTextColor = NeutralMedium,
                errorBorderColor = CriticalMedium,
                errorTextColor = NeutralDark
            ),
            enabled = enabled,
            readOnly = enabled,
            isError = errorMessage != null,
            supportingText = errorMessage?.let {
                {
                    Text(
                        text = it,
                        color = CriticalMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
        )
    }
}