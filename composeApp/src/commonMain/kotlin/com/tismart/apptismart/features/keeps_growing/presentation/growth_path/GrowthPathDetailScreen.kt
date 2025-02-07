package com.tismart.apptismart.features.keeps_growing.presentation.growth_path

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.NeutralDark
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.features.keeps_growing.presentation.components.GrowthPathDetailMesh
import com.tismart.apptismart.features.keeps_growing.presentation.components.KeepsGrowingHeader
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.growth_path_flag
import tismartproject.composeapp.generated.resources.growth_path_man
import tismartproject.composeapp.generated.resources.growth_path_woman

@Composable
fun GrowthPathDetailScreen(
    isAMan: Boolean,
    growthPath: GrowthPath
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        KeepsGrowingHeader(
            title = growthPath.title,
            onMenuClick = {},
            onNotificationsClick = {},
            onBackClick = {}
        )

        Column(
            modifier = Modifier.padding(horizontal = 30.dp).padding(top = 20.dp)
        ) {

            Text(
                text = growthPath.description,
                color = NeutralDarkest,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Cursos Soft skills",
                modifier = Modifier.padding(top = 20.dp),
                color = SecundarioDark,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.headlineSmall
            )

            growthPath.softSkillsCourses.forEach {
                Text(
                    text = "• $it",
                    color = NeutralDarkest
                )
            }

            Text(
                text = "Cursos Hard skills",
                modifier = Modifier.padding(top = 30.dp),
                color = SecundarioDark,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.headlineSmall
            )

            growthPath.hardSkillsCourses.forEach {
                Text(
                    text = "• $it",
                    color = NeutralDarkest
                )
            }

            Text(
                text = "Sigue avanzando para alcanzar tu meta",
                color = NeutralDark,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 38.dp, bottom = 36.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                style = MaterialTheme.typography.titleMedium
            )

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(Res.drawable.growth_path_flag),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 12.dp, end = 24.dp)
                        .width(80.dp)
                )
                LinearProgressIndicator(
                    progress = {
                        0.7f
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp, vertical = 12.dp).height(12.dp)
                        .border(1.5.dp, PrimarioMedium, CircleShape),
                    color = PrimarioMedium,
                    trackColor = Color.White
                )
                Image(
                    painter = painterResource(if (isAMan) Res.drawable.growth_path_man else Res.drawable.growth_path_woman),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .width(100.dp)
                )
            }
        }

        GrowthPathDetailMesh()
    }
}