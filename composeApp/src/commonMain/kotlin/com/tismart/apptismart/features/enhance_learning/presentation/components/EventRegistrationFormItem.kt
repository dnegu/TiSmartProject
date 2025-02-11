package com.tismart.apptismart.features.enhance_learning.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.attach_file

@Composable
fun EventRegistrationFormEvent(
    event: String
) {
    EventRegistrationFormItem(
        label = "Evento"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = event,
            onValueChange = {},
            readOnly = true,
            enabled = false,
            textStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
            singleLine = true,
            trailingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.attach_file),
                    contentDescription = null,
                    tint = NeutralMedium
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = NeutralMedium,
                disabledBorderColor = NeutralMedium,
                disabledTrailingIconColor = NeutralMedium,
                disabledContainerColor = Color.Transparent
            )
        )
    }
}

@Composable
fun EventRegistrationFormEnrollmentReason(
    reason: String,
    isError: Boolean,
    onReasonChange: (String) -> Unit,
) {
    EventRegistrationFormItem(
        label = "¿Motivo de inscripción?"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = reason,
            onValueChange = onReasonChange,
            textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Medium),
            isError = isError,
            supportingText = {
                if (isError) {
                    Text(
                        text = "Campo incompleto",
                        color = CriticalMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                } else {
                    Text(
                        text = "Max 150 caracteres",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        color = NeutralDarkMedium,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            },
            minLines = 4,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedBorderColor = NeutralMedium,
                focusedBorderColor = NeutralMedium,
                unfocusedTextColor = NeutralDarkest,
                focusedTextColor = NeutralDarkest,
                errorBorderColor = CriticalMedium,
                errorTextColor = NeutralDarkest
            )
        )
    }
}

@Composable
private fun EventRegistrationFormItem(
    label: String,
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = label,
            color = NeutralDarkMedium,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyLarge
        )
        content()
    }
}