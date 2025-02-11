package com.tismart.apptismart.features.enhance_learning.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.components.HyperlinkText
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.attach_file

@Composable
fun AcceptTermsAndConditionsItem(
    checkedState: Boolean,
    isError: Boolean,
    onStateChange: (Boolean) -> Unit
) {
    Row(
        Modifier.fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null, // null recommended for accessibility with screenreaders
            colors = CheckboxDefaults.colors(
                checkedColor = PrimarioMedium,
                uncheckedColor = if (isError) CriticalMedium else NeutralMedium
            )
        )
        HyperlinkText(
            modifier = Modifier.padding(start = 16.dp),
            text = "Acepto haber leído los términos y condiciones del convenio educativo.",
            linkText = listOf("términos y condiciones"),
            hyperlinks = listOf("https://developer.android.com/compose"),
            textStyle = MaterialTheme.typography.bodySmall.copy(color = NeutralDarkest),
            linkTextColor = PrimarioMedium
        )
    }
}

@Composable
fun RegistrationFormEnrollmentReason(
    reason: String,
    isError: Boolean,
    onReasonChange: (String) -> Unit,
) {
    RegistrationFormItem(
        title = "¿Cómo ayudaría este curso con el proyecto en el que trabajas?"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = reason,
            onValueChange = onReasonChange,
            textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Medium),
            isError = isError,
            supportingText = {
                if (isError) {
                    Text(text = "Campo incompleto", color = CriticalMedium, fontWeight = FontWeight.SemiBold)
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
                errorTextColor = NeutralDarkest,
                errorContainerColor = Color.Transparent
            )
        )
    }
}

@Composable
fun RegistrationFormCourse(
    course: String,
    isError: Boolean,
    onCourseChange: (String) -> Unit,
) {
    RegistrationFormItem(
        title = "Curso o certificado"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = course,
            onValueChange = onCourseChange,
            textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Medium),
            singleLine = true,
            isError = isError,
            supportingText = if (isError) {
                { Text(text = "Campo incompleto", color = CriticalMedium, fontWeight = FontWeight.SemiBold) }
            } else {
                null
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = NeutralDarkest,
                focusedBorderColor = NeutralMedium,
                focusedContainerColor = Color.Transparent,
                unfocusedTextColor = NeutralDarkest,
                unfocusedBorderColor = NeutralMedium,
                unfocusedContainerColor = Color.Transparent,
                errorBorderColor = CriticalMedium,
                errorTextColor = NeutralDarkest,
                errorContainerColor = Color.Transparent
            )
        )
    }
}

@Composable
fun RegistrationFormCourseLink(
    link: String,
    isError: Boolean,
    onLinkChange: (String) -> Unit,
) {
    RegistrationFormItem(
        title = "Enlace del curso o certificado"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = link,
            onValueChange = onLinkChange,
            textStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
            singleLine = true,
            isError = isError,
            supportingText = if (isError) {
                { Text(text = "Enlace inválido", color = CriticalMedium, fontWeight = FontWeight.SemiBold) }
            } else {
                null
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.attach_file),
                    contentDescription = null,
                    tint = if (isError) CriticalMedium else NeutralMedium
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = PrimarioMedium,
                focusedBorderColor = NeutralMedium,
                focusedTrailingIconColor = NeutralMedium,
                focusedContainerColor = Color.Transparent,
                unfocusedTextColor = PrimarioMedium,
                unfocusedBorderColor = NeutralMedium,
                unfocusedTrailingIconColor = NeutralMedium,
                unfocusedContainerColor = Color.Transparent,
                errorBorderColor = CriticalMedium,
                errorTextColor = NeutralDarkest,
                errorContainerColor = Color.Transparent
            )
        )
    }
}

@Composable
private fun RegistrationFormItem(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            color = NeutralDarkMedium,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyLarge
        )
        content()
    }
}