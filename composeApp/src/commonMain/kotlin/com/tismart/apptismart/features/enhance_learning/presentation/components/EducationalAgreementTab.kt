package com.tismart.apptismart.features.enhance_learning.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDarkMedium
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TISmartActionButton
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.RegistrationFormError
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.RegistrationStatus
import org.jetbrains.compose.resources.painterResource

@Composable
fun EducationalAgreementTab(
    onSubmitApplicationClick: () -> Unit,
    onHistoryItemClick: () -> Unit
) {
    Text(
        text = "Formulario de postulación",
        modifier = Modifier.padding(top = 12.dp),
        color = SecundarioDark,
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.headlineSmall
    )

    var state by remember { mutableStateOf(0) }
    val titles = listOf("Inscripción", "Historial")
    TabRow(
        selectedTabIndex = state,
        containerColor = Color.White,
        contentColor = PrimarioMedium,
        divider = { HorizontalDivider(thickness = 6.dp, color = NeutralLight) },
        indicator = @Composable { tabPositions ->
            if (state < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    height = 6.dp,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[state]),
                    color = PrimarioMedium
                )
            }
        }
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = state == index,
                onClick = { state = index },
                text = {
                    Text(
                        text = title, maxLines = 2, overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                unselectedContentColor = NeutralDarkMedium
            )
        }
    }

    when (state) {
        0 -> RegistrationTab(
            onSubmitApplicationClick = onSubmitApplicationClick
        )

        1 -> HistoryTab(
            onItemClick = onHistoryItemClick
        )
    }
}

@Composable
private fun RegistrationTab(
    onSubmitApplicationClick: () -> Unit
) {
    Text(
        text = "Completa el formulario para inscribirte y solicitar un nuevo convenio educativo.",
        style = MaterialTheme.typography.bodyMedium
    )

    var course by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    var link by remember { mutableStateOf("") }
    val (checkedState, onStateChange) = remember { mutableStateOf(false) }

    val registrationFormError by remember { mutableStateOf(RegistrationFormError()) }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RegistrationFormCourse(
            course = course,
            isError = registrationFormError.course,
            onCourseChange = { course = it }
        )

        RegistrationFormEnrollmentReason(
            reason = reason,
            isError = registrationFormError.reason,
            onReasonChange = { reason = it }
        )

        RegistrationFormCourseLink(
            link = link,
            isError = registrationFormError.link,
            onLinkChange = { link = it }
        )

        AcceptTermsAndConditionsItem(
            checkedState = checkedState,
            isError = registrationFormError.termsAndConditions,
            onStateChange = onStateChange
        )
    }

    TISmartActionButton(
        text = "Enviar solicitud",
        isLoading = false,
        enabled = course.isNotBlank() && reason.isNotBlank() && link.isNotBlank() && checkedState,
        onClick = onSubmitApplicationClick
    )

}

@Composable
private fun HistoryTab(
    onItemClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.heightIn(max = 500.dp)
    ) {
        item {
            ProposalHistoryItem(
                agreementName = "Interaction Design Foundation",
                status = RegistrationStatus.SENT,
                onItemClick = onItemClick
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                agreementName = "Interaction Design Foundation",
                status = RegistrationStatus.UNDER_REVIEW,
                onItemClick = onItemClick
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                agreementName = "Interaction Design Foundation",
                status = RegistrationStatus.APPROVED,
                onItemClick = onItemClick
            )
            HorizontalDivider(color = NeutralLight)
        }
        item {
            ProposalHistoryItem(
                agreementName = "Interaction Design Foundation",
                status = RegistrationStatus.NOT_APPROVED,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun ProposalHistoryItem(
    agreementName: String,
    status: RegistrationStatus,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = agreementName,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(status.backgroundColor)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(status.icon),
                    contentDescription = null,
                    tint = status.textColor,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = status.label,
                    color = status.textColor,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = null,
                tint = NeutralDarkMedium
            )
        }
    }
}