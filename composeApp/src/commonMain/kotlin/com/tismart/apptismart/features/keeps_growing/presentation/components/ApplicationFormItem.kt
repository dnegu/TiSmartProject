package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.CriticalMedium
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.PrimarioMedium
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.attach_file

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicationFormArea(
    area: String,
    options: List<String>,
    isError: Boolean,
    onAreaChange: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ApplicationFormItem(
        label = "Área"
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            OutlinedTextField(
                // The `menuAnchor` modifier must be passed to the text field to handle
                // expanding/collapsing the menu on click. A read-only text field has
                // the anchor type `PrimaryNotEditable`.
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth(),
                value = area,
                onValueChange = {},
                readOnly = true,
                textStyle = LocalTextStyle.current.copy(color = NeutralDarkest, fontWeight = FontWeight.Medium),
                singleLine = true,
                isError = isError,
                placeholder = { Text(text = "Seleccionar", color = NeutralDarkMedium, fontWeight = FontWeight.Medium) },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.rotate(if (expanded) 180f else 0f),
                        tint = PrimarioMedium
                    )
                },
                supportingText = if (isError) {
                    { Text(text = "Debes de elegir una opción", color = CriticalMedium, fontWeight = FontWeight.SemiBold) }
                } else {
                    null
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = NeutralMedium,
                    focusedIndicatorColor = NeutralMedium,
                    focusedTextColor = NeutralDarkest,
                    unfocusedTextColor = NeutralDarkest,
                    errorIndicatorColor = CriticalMedium,
                    errorContainerColor = Color(0xFFFBFBFB)
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                containerColor = Color.White,
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option, style = MaterialTheme.typography.bodyLarge) },
                        onClick = {
                            onAreaChange(option)
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
}

@Composable
fun ApplicationFormCurrentPosition(
    currentPosition: String,
    isError: Boolean,
    onCurrentPositionChange: (String) -> Unit,
) {
    ApplicationFormItem(
        label = "Puesto actual"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentPosition,
            onValueChange = onCurrentPositionChange,
            textStyle = LocalTextStyle.current.copy(color = NeutralDarkest, fontWeight = FontWeight.Medium),
            singleLine = true,
            isError = isError,
            supportingText = if (isError) {
                { Text(text = "Campo incompleto", color = CriticalMedium, fontWeight = FontWeight.SemiBold) }
            } else {
                null
            },
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
fun ApplicationFormYourExperience(
    experience: String,
    isError: Boolean,
    onExperienceChange: (String) -> Unit,
) {
    ApplicationFormItem(
        label = "Cuéntanos de tu experiencia"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = experience,
            onValueChange = onExperienceChange,
            textStyle = LocalTextStyle.current.copy(color = NeutralDarkest, fontWeight = FontWeight.Medium),
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
                errorTextColor = NeutralDarkest
            )
        )
    }
}

@Composable
fun ApplicationFormMotivation(
    motivation: String,
    isError: Boolean,
    onMotivationChange: (String) -> Unit,
) {
    ApplicationFormItem(
        label = "¿Qué te motiva a ser mentor?"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = motivation,
            onValueChange = onMotivationChange,
            textStyle = LocalTextStyle.current.copy(color = NeutralDarkest, fontWeight = FontWeight.Medium),
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
                errorTextColor = NeutralDarkest
            )
        )
    }
}

@Composable
fun ApplicationFormAttachCV(
    cv: String,
    isError: Boolean,
    onAttachCVClick: () -> Unit,
) {
    ApplicationFormItem(
        label = "Adjuntar CV"
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().clickable(onClick = onAttachCVClick),
            value = cv,
            onValueChange = {},
            readOnly = true,
            enabled = false,
            textStyle = LocalTextStyle.current.copy(fontWeight = FontWeight.Medium),
            singleLine = true,
            isError = isError,
            supportingText = if (isError) {
                { Text(text = "Debe de adjuntar un archivo", color = CriticalMedium, fontWeight = FontWeight.SemiBold) }
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
                disabledTextColor = PrimarioMedium,
                disabledBorderColor = NeutralMedium,
                disabledTrailingIconColor = NeutralMedium,
                disabledContainerColor = Color.Transparent,
                errorBorderColor = CriticalMedium
            )
        )
    }
}


@Composable
private fun ApplicationFormItem(
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