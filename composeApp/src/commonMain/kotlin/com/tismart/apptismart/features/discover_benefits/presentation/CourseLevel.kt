package com.tismart.apptismart.features.discover_benefits.presentation

import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.AmarilloClaro
import com.tismart.apptismart.core.presentation.AmarilloOscuro
import com.tismart.apptismart.core.presentation.RojoClaro
import com.tismart.apptismart.core.presentation.RojoOscuro
import com.tismart.apptismart.core.presentation.VerdeClaro
import com.tismart.apptismart.core.presentation.VerdeOscuro

enum class CourseLevel(val title: String, val backgroundColor: Color, val textColor: Color) {
    BEGINNER(title = "Básico", backgroundColor = AmarilloClaro, textColor = AmarilloOscuro),
    INTERMEDIATE(title = "Intermedio", backgroundColor = VerdeClaro, textColor = VerdeOscuro),
    ADVANCED(title = "Avanzado", backgroundColor = RojoClaro, textColor = RojoOscuro)
}