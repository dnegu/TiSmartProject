package com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement

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
import tismartproject.composeapp.generated.resources.sent_status
import tismartproject.composeapp.generated.resources.under_review_status

enum class RegistrationStatus(val title: String, val icon: DrawableResource, val backgroundColor: Color, val color: Color) {
    SENT(title = "Enviado", icon = Res.drawable.sent_status, backgroundColor = CelesteClaro, color = CelesteOscuro),
    UNDER_REVIEW(title = "En revisión", icon = Res.drawable.under_review_status, backgroundColor = AmarilloClaro, color = AmarilloOscuro),
    APPROVED(title = "Aprobado", icon = Res.drawable.approved_status, backgroundColor = VerdeClaro, color = VerdeOscuro),
    NOT_APPROVED(title = "No aprobado", icon = Res.drawable.approved_status, backgroundColor = RojoClaro, color = RojoOscuro)
}