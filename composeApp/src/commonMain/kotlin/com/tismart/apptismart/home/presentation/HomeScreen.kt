package com.tismart.apptismart.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioMedium
import com.tismart.apptismart.core.presentation.components.TiSmartTopBar
import com.tismart.apptismart.home.presentation.components.HomeCard
import com.tismart.apptismart.home.presentation.components.HomePager
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.check_profile
import tismartproject.composeapp.generated.resources.gift_box
import tismartproject.composeapp.generated.resources.graduation_hat
import tismartproject.composeapp.generated.resources.robot
import tismartproject.composeapp.generated.resources.star_badge
import tismartproject.composeapp.generated.resources.visibility_on

@Composable
fun HomeScreenRoot(
    viewModel: HomeViewModel = koinViewModel(),
) {
    HomeScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit
) {


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TiSmartTopBar(
                onBackClick = { onAction(HomeAction.OnBackClick) },
                onNotificationsClick = { onAction(HomeAction.OnNotificationsClick) }
            )

            HomePager()

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .clip(RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp))
                    .background(PrimarioMedium)
                    .padding(vertical = 9.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Ver todas las noticias",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .background(HomeBackground)
                    .padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hola, Ronald",
                    modifier = Modifier.padding(bottom = 12.dp),
                    color = NeutralDarkest,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "¿Qué quieres hacer hoy?",
                    color = NeutralDarkest,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.titleMedium
                )

                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = PrimarioMedium
                    )
                ) {
                    Text(
                        text = "Descubre quién es tu TiSmart Buddy",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(Res.drawable.visibility_on),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                    )
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(
                        horizontal = 18.dp,
                        vertical = 16.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    item {
                        HomeCard(
                            title = "Seguir creciendo",
                            image = Res.drawable.star_badge,
                            onClick = {}
                        )
                    }
                    item {
                        HomeCard(
                            title = "Potenciar mi aprendizaje",
                            image = Res.drawable.graduation_hat,
                            onClick = {}
                        )
                    }
                    item {
                        HomeCard(
                            title = "Buscar nuevas vacantes",
                            image = Res.drawable.check_profile,
                            onClick = {}
                        )
                    }
                    item {
                        HomeCard(
                            title = "Descubrir mis beneficios",
                            image = Res.drawable.gift_box,
                            onClick = {}
                        )
                    }
                }

            }
        }

        FloatingActionButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomEnd).padding(18.dp),
            shape = CircleShape,
            containerColor = SecundarioMedium
        ) {
            Image(
                painter = painterResource(Res.drawable.robot),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.padding(10.dp).width(28.dp)
            )
        }
    }
}