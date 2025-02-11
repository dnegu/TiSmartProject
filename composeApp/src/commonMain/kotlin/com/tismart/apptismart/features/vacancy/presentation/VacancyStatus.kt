package com.tismart.apptismart.features.vacancy.presentation

import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.AmarilloClaro
import com.tismart.apptismart.core.presentation.AmarilloOscuro
import com.tismart.apptismart.core.presentation.CelesteClaro
import com.tismart.apptismart.core.presentation.CelesteOscuro
import com.tismart.apptismart.core.presentation.RojoClaro
import com.tismart.apptismart.core.presentation.RojoOscuro
import com.tismart.apptismart.core.presentation.VerdeClaro
import com.tismart.apptismart.core.presentation.VerdeOscuro
import org.jetbrains.compose.resources.DrawableResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.approved_status
import tismartproject.composeapp.generated.resources.interview_status
import tismartproject.composeapp.generated.resources.not_approved_status
import tismartproject.composeapp.generated.resources.sent_status
import tismartproject.composeapp.generated.resources.under_review_status

enum class VacancyStatus(val label: String, icon: DrawableResource, val backgroundColor: Color, val textColor: Color) {
    SENT(label = "Enviado", icon = Res.drawable.sent_status, backgroundColor = CelesteClaro, textColor = CelesteOscuro),
    UNDER_REVIEW(label = "En revisión", icon = Res.drawable.under_review_status, backgroundColor = AmarilloClaro, textColor = AmarilloOscuro),
    NOT_PROCEEDING(label = "No procede", icon = Res.drawable.not_approved_status, backgroundColor = RojoClaro, textColor = RojoOscuro),
    HIRED(label = "Contratado", icon = Res.drawable.approved_status, backgroundColor = VerdeClaro, textColor = VerdeOscuro),
    INTERVIEW(label = "Entrevista", icon = Res.drawable.interview_status, backgroundColor = AmarilloClaro, textColor = AmarilloOscuro)
}