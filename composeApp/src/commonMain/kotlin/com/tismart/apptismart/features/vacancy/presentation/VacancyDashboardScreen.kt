package com.tismart.apptismart.features.vacancy.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.discover_benefits.presentation.components.DiscoverBenefitsSearchBar
import com.tismart.apptismart.features.vacancy.presentation.components.VacancyDashboardRecommendedList
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.add_box
import tismartproject.composeapp.generated.resources.share_copy

@Composable
fun VacancyDashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TiSmartHeader(
            title = "Busca nuevas vacantes",
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        Text(
            text = "¡Aquí puedes ver el progreso de tu solicitud de Convenio Educativo!",
            modifier = Modifier.background(SecundarioDark).padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )

        DiscoverBenefitsSearchBar(
            text = "Buscar vacantes",
            onSearchBarClick = {}
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(SecundarioDark)
                .padding(start = 30.dp)
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.share_copy),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Mis postulaciones",
                        color = Color.White
                    )
                }
            }


            item {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.add_box),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Nuevas vacantes",
                        color = Color.White
                    )
                }
            }
        }

        VacancyDashboardRecommendedList(
            onSeeAllClick = {}
        )
    }
}