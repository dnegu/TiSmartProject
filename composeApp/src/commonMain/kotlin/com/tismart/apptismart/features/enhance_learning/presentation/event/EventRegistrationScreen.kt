package com.tismart.apptismart.features.enhance_learning.presentation.event

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import com.tismart.apptismart.features.enhance_learning.presentation.components.EventRegistrationBody
import com.tismart.apptismart.features.enhance_learning.presentation.components.EventRegistrationHeader
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.tismart_university_avatar
import tismartproject.composeapp.generated.resources.tismart_university_display

@Composable
fun EventRegistrationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        EventRegistrationHeader(
            image = Res.drawable.tismart_university_display,
            name = "Ethical Hacking",
            courseLevel = CourseLevel.BEGINNER
        )

        EventRegistrationBody(
            image = Res.drawable.tismart_university_avatar,
            speaker = "Alejandro Saenz",
            date = "25 de setiembre",
            description = "Aprende todo sobre Ciberseguridad en este workshop, donde descubrirás cómo proteger tus datos, prevenir ataques digitales y gestionar riesgos en el entorno virtual. Conoce herramientas clave y estrategias prácticas para mantener tu información segura en un mundo cada vez más conectado."
        )

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 24.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimarioMedium,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Inscribirme",
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}