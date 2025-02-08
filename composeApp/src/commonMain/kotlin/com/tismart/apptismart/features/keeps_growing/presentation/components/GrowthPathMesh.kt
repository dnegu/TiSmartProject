package com.tismart.apptismart.features.keeps_growing.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.NeutralMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.growth_path_mesh

@Composable
fun GrowthPathMesh() {
    Box(
        modifier = Modifier.padding(top = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        BoxWithConstraints(
            Modifier
                .padding(top = 15.dp)
                .align(Alignment.TopCenter)
                .width(200.dp)
                .height(28.dp)
        ) {
            val aspectRatio = maxWidth / maxHeight
            Box(
                Modifier
                    .fillMaxSize()
                    .scale(maxOf(aspectRatio, 1f), maxOf(1 / aspectRatio, 1f))
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                NeutralDarkest,
                                SecundarioDark
                            )
                        ),
                    )
            )
        }

        Image(
            painter = painterResource(Res.drawable.growth_path_mesh),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(),
            colorFilter = ColorFilter.tint(Color(0xFF6228D2))
        )
    }
}

@Composable
fun GrowthPathDetailMesh() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(NeutralLight)
        )

        BoxWithConstraints(
            Modifier
                .padding(top = 6.dp)
                .align(Alignment.TopCenter)
                .width(220.dp)
                .height(30.dp)
        ) {
            val aspectRatio = maxWidth / maxHeight
            Box(
                Modifier
                    .fillMaxSize()
                    .scale(maxOf(aspectRatio, 1f), maxOf(1 / aspectRatio, 1f))
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                NeutralMedium,
                                NeutralLight,
                            )
                        ),
                    )
            )
        }
    }
}