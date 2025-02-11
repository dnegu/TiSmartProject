package com.tismart.apptismart.features.enhance_learning.presentation.tismart_university

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.CourseLevel
import com.tismart.apptismart.features.enhance_learning.presentation.components.CourseRepositoryDialog
import com.tismart.apptismart.features.enhance_learning.presentation.components.TiSmartLoversCourseDetailHeader
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.tismart_university_card

@Composable
fun TiSmartLoversCourseDetailScreen() {
    var showDialog by remember { mutableStateOf(false) }
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

        TiSmartLoversCourseDetailHeader(
            image = Res.drawable.tismart_university_card,
            name = "Angular desde cero",
            description = "Sumérgete en el mundo de Angular, uno de los frameworks de JavaScript más populares para construir aplicaciones web dinámicas. Aprende desde los conceptos básicos como componentes, módulos y servicios, hasta la creación de una aplicación completa. Ideal para quienes buscan dominar el desarrollo frontend con herramientas modernas y prácticas recomendadas.",
            author = "Maria Gamarra",
            courseLevel = CourseLevel.BEGINNER
        )

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 18.dp, bottom = 4.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimarioMedium,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Ir a Repositorio",
                modifier = Modifier.padding(vertical = 4.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    CourseRepositoryDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onGoToRepositoryClick = { showDialog = false }
    )
}