package com.tismart.apptismart.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.HomeBackground
import com.tismart.apptismart.core.presentation.PrimarioLightest
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.SecundarioLight
import com.tismart.apptismart.core.presentation.SecundarioLightest
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.robot

@Composable
fun HomeChatBot(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(SecundarioDark)
                .padding(horizontal = 18.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Chatea con TiBot", color = Color.White)

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = Color.White
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            item {
                Message(
                    msg = "¡Buen día! \uD83D\uDE0A ¿En qué puedo ayudarte hoy?",
                    isUserMe = false
                )
            }

            item {
                Message(
                    msg = "¿Cuántos días de vacaciones tengo pendientes?",
                    isUserMe = true
                )
            }

            item {
                Message(
                    msg = "Al día de hoy, tienes 15 días de vacaciones pendientes, que vencerán el 18 de enero de 2026.",
                    isUserMe = false
                )
            }
        }
    }
}

@Composable
fun Message(
    msg: String,
    isUserMe: Boolean
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = if (isUserMe) Arrangement.End else Arrangement.Start
    ) {
        if (!isUserMe) {
            // Avatar
            Image(
                modifier = Modifier
                    .padding(end = 2.dp)
                    .size(42.dp)
                    .border(3.dp, MaterialTheme.colorScheme.surface, CircleShape)
                    .clip(CircleShape)
                    .background(SecundarioLightest)
                    .padding(horizontal = 8.dp),
                painter = painterResource(Res.drawable.robot),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )
        }


        val chatModifier = if (isUserMe) Modifier.fillMaxSize(0.8f) else Modifier.fillMaxWidth(0.9f)
        ChatItemBubble(
            modifier = chatModifier,
            message = msg,
            isUserMe = isUserMe
        )
    }
}

@Composable
fun ChatItemBubble(
    modifier: Modifier,
    message: String,
    isUserMe: Boolean
) {

    val backgroundBubbleColor = if (isUserMe) {
        PrimarioLightest
    } else {
        HomeBackground
    }

    Surface(
        modifier = modifier,
        color = backgroundBubbleColor,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}