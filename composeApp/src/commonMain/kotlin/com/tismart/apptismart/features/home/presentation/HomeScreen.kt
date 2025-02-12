package com.tismart.apptismart.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.tismart.apptismart.features.home.presentation.components.HomeChatbot
import com.tismart.apptismart.features.home.presentation.components.HomeGridWithCards
import com.tismart.apptismart.features.home.presentation.components.HomePager
import com.tismart.apptismart.features.home.presentation.components.HomeTiSmartBuddyDialog
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.profile_avatar
import tismartproject.composeapp.generated.resources.robot
import tismartproject.composeapp.generated.resources.visibility_on

@Composable
fun HomeScreenRoot(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSeeAllNewsClick: () -> Unit,
    onKeepGrowingClick: () -> Unit,
    onSearchForNewVacanciesClick: () -> Unit,
    onEnhanceLearningClick: () -> Unit,
    onDiscoverMyBenefitsClick: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    HomeScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                HomeAction.OnProfileClick -> onProfileClick()
                HomeAction.OnNotificationsClick -> onNotificationsClick()
                HomeAction.OnSeeAllNewsClick -> onSeeAllNewsClick()
                HomeAction.OnKeepGrowingClick -> onKeepGrowingClick()
                HomeAction.OnSearchForNewVacanciesClick -> onSearchForNewVacanciesClick()
                HomeAction.OnEnhanceLearningClick -> onEnhanceLearningClick()
                HomeAction.OnDiscoverMyBenefitsClick -> onDiscoverMyBenefitsClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    val scope = rememberCoroutineScope()
    var showChatbot by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            TiSmartTopBar(
                notificationCount = state.notificationCount,
                onMenuClick = { onAction(HomeAction.OnProfileClick) },
                onNotificationsClick = { onAction(HomeAction.OnNotificationsClick) }
            )

            HomePager()

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .clip(RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp))
                    .clickable(onClick = { onAction(HomeAction.OnSeeAllNewsClick) })
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
                    onClick = { onAction(HomeAction.OnTiSmartBuddyClick) },
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

                HomeGridWithCards(
                    onKeepGrowingClick = { onAction(HomeAction.OnKeepGrowingClick) },
                    onSearchForNewVacanciesClick = { onAction(HomeAction.OnSearchForNewVacanciesClick) },
                    onEnhanceLearningClick = { onAction(HomeAction.OnEnhanceLearningClick) },
                    onDiscoverMyBenefitsClick = { onAction(HomeAction.OnDiscoverMyBenefitsClick) }
                )
            }
        }

        FloatingActionButton(
            onClick = { showChatbot = true },
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

    HomeChatbot(
        showChatbot = showChatbot,
        sheetState = sheetState,
        onDismiss = { showChatbot = false },
        onCloseClick = {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    showChatbot = false
                }
            }
        }
    )

    HomeTiSmartBuddyDialog(
        showDialog = state.showTiSmartBuddyDialog,
        image = Res.drawable.profile_avatar,
        name = "Daniel Varillas",
        description = "Daniel es súper divertido; le encanta ir al cine, jugar videojuegos con sus amigos y sumergirse en un buen libro. Además, es hincha de la “U”.",
        onDismiss = { onAction(HomeAction.DismissTiSmartBuddyDialog) },
        onCommunicateClick = { onAction(HomeAction.DismissTiSmartBuddyDialog) }
    )
}