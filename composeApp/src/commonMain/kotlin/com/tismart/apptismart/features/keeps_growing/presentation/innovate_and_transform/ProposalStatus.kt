package com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform

import androidx.compose.ui.graphics.Color
import com.tismart.apptismart.core.presentation.AmarilloClaro
import com.tismart.apptismart.core.presentation.AmarilloOscuro
import com.tismart.apptismart.core.presentation.CelesteClaro
import com.tismart.apptismart.core.presentation.CelesteOscuro
import com.tismart.apptismart.core.presentation.MoradoClaro
import com.tismart.apptismart.core.presentation.MoradoOscuro
import com.tismart.apptismart.core.presentation.TurquesaClaro
import com.tismart.apptismart.core.presentation.TurquesaOscuro
import com.tismart.apptismart.core.presentation.VerdeClaro
import com.tismart.apptismart.core.presentation.VerdeOscuro
import org.jetbrains.compose.resources.DrawableResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.approved_status
import tismartproject.composeapp.generated.resources.in_progress_status
import tismartproject.composeapp.generated.resources.sent_status
import tismartproject.composeapp.generated.resources.under_review_status

enum class ProposalStatus(val title: String, val icon: DrawableResource, val backgroundColor: Color, val color: Color) {
    SENT(title = "Enviado", icon = Res.drawable.sent_status, backgroundColor = CelesteClaro, color = CelesteOscuro),
    UNDER_REVIEW(title = "En revisión", icon = Res.drawable.under_review_status, backgroundColor = AmarilloClaro, color = AmarilloOscuro),
    APPROVED(title = "Aprobado", icon = Res.drawable.approved_status, backgroundColor = VerdeClaro, color = VerdeOscuro),
    IN_PROGRESS(title = "En ejecución", icon = Res.drawable.in_progress_status, backgroundColor = MoradoClaro, color = MoradoOscuro),
    COMPLETED(title = "Finalizado", icon = Res.drawable.approved_status, backgroundColor = TurquesaClaro, color = TurquesaOscuro)
}