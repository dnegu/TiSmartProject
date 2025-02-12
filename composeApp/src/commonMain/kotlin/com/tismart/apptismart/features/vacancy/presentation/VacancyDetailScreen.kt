package com.tismart.apptismart.features.vacancy.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.vacancy.presentation.components.ApplyToVacancyDialog
import com.tismart.apptismart.features.vacancy.presentation.components.VacancyDetailBody
import com.tismart.apptismart.features.vacancy.presentation.components.VacancyDetailHeader
import com.tismart.apptismart.features.vacancy.presentation.components.VacancyDetailInfo

@Composable
fun VacancyDetailScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit
) {
    VacancyDetailScreen(
        onAction = { action ->
            when (action) {
                VacancyAction.OnProfileClick -> onProfileClick()
                VacancyAction.OnNotificationsClick -> onNotificationsClick()
                VacancyAction.OnBackClick -> onBackClick()
                else -> Unit
            }
        }
    )
}

@Composable
fun VacancyDetailScreen(
    onAction: (VacancyAction) -> Unit
) {
    var isShared by remember { mutableStateOf(false) }
    var showApplyNowDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            notificationCount = 0,
            onMenuClick = { onAction(VacancyAction.OnProfileClick) },
            onNotificationsClick = { onAction(VacancyAction.OnNotificationsClick) },
            onBackClick = { onAction(VacancyAction.OnBackClick) }
        )

        VacancyDetailHeader(
            name = "Service Designer",
            location = "Lima, Perú. (En remoto)"
        )

        VacancyDetailInfo(
            jobNumber = "N° de puesto: 0023",
            announcementDate = "12/04/24",
            applicationDeadline = "15/04/24",
            leader = "Vanessa Amoros",
            isShared = isShared,
            onApplyNowClick = { showApplyNowDialog = true },
            onShareClick = { isShared = true },
            onShareCloseClick = { isShared = false }
        )

        VacancyDetailBody(
            description = "En TISmart buscamos un/a DevOps Engineer que se una a nuestro equipo y participe en un proyecto para uno de nuestros clientes. Si te apasiona la automatización, la estabilidad de infraestructuras y el despliegue seguro de microservicios. ¡Esta es tu oportunidad!",
            challenges = listOf(
                "Desplegar y administrar la infraestructura de OpenIAM en entornos Docker Swarm y Kubernetes (GKE) en GCP.",
                "Asegurar la estabilidad de los ambientes, dando un grado de madurez a la infraestructura y escalando cuando sea necesario.",
                "Evaluar y aplicar el desacoplamiento de servicios de OpenIAM, optimizando su integración con RPM y buenas prácticas de la industria."
            ),
            competencies = listOf(
                "Experiencia en la gestión de Docker Swarm, Kubernetes (preferentemente en GKE), y despliegue en entornos GCP.",
                "Capacidad para mejorar la madurez y estabilidad de infraestructuras, llevando proyectos en GCP.",
                "Experiencia en creación de pipelines de despliegue y automatización con Azure DevOps."
            ),
            benefits = listOf(
                "Beneficios corporativos dirigidos a nuestros colaboradores TI.",
                "Participación en proyectos de gran impacto.",
                "Ambiente de trabajo enfocado en la innovación y desarrollo.",
                "Un equipo colaborativo y orientado a la agilidad.",
                "Posibilidad de crecimiento y aprendizaje continuo.",
                "Salario competitivo acorde al mercado.",
                "Modalidad de trabajo remoto."
            )
        )
    }

    ApplyToVacancyDialog(
        showDialog = showApplyNowDialog,
        onDismiss = { showApplyNowDialog = false },
        onApplyNowClick = { showApplyNowDialog = false }
    )
}