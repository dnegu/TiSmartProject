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

enum class ProposalStatus(val label: String, val detail: String? = null, val icon: DrawableResource, val backgroundColor: Color, val textColor: Color) {
    SENT(label = "Enviado", icon = Res.drawable.sent_status, backgroundColor = CelesteClaro, textColor = CelesteOscuro),
    UNDER_REVIEW(label = "En revisión", detail = "Tu solicitud se encuentra en revisión. Recibirás una notificación cuando pase a la siguiente etapa.", icon = Res.drawable.under_review_status, backgroundColor = AmarilloClaro, textColor = AmarilloOscuro),
    APPROVED(label = "Aprobado", icon = Res.drawable.approved_status, backgroundColor = VerdeClaro, textColor = VerdeOscuro),
    IN_PROGRESS(label = "En ejecución", icon = Res.drawable.in_progress_status, backgroundColor = MoradoClaro, textColor = MoradoOscuro),
    COMPLETED(label = "Finalizado", icon = Res.drawable.approved_status, backgroundColor = TurquesaClaro, textColor = TurquesaOscuro)
}