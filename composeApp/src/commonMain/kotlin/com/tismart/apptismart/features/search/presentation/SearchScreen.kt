package com.tismart.apptismart.features.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tismart.apptismart.core.presentation.NeutralDarkest
import com.tismart.apptismart.core.presentation.NeutralLight
import com.tismart.apptismart.core.presentation.PrimarioMedium
import com.tismart.apptismart.core.presentation.SecundarioDark
import com.tismart.apptismart.core.presentation.components.TiSmartHeader
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathAction
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreen
import org.jetbrains.compose.resources.painterResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.search

@Composable
fun SearchScreenRoot(
    searchType: SearchType,
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onBackClick: () -> Unit,
    onSearchResultClick: (String) -> Unit
) {
    SearchScreen(
        searchType = searchType,
        onAction = { action ->
            when (action) {
                SearchAction.OnProfileClick -> onProfileClick()
                SearchAction.OnNotificationsClick -> onNotificationsClick()
                SearchAction.OnBackClick -> onBackClick()
                is SearchAction.OnSearchResultClick -> onSearchResultClick(action.result)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    searchType: SearchType,
    onAction: (SearchAction) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    val isNotFounds: String? = null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SecundarioDark)
    ) {
        TiSmartHeader(
            title = searchType.title,
            notificationCount = 0,
            onMenuClick = { onAction(SearchAction.OnProfileClick) },
            onNotificationsClick = { onAction(SearchAction.OnNotificationsClick) },
            onBackClick = { onAction(SearchAction.OnBackClick) }
        )

        searchType.description?.let {
            Text(
                text = it,
                modifier = Modifier.background(SecundarioDark).padding(horizontal = 30.dp)
                    .padding(bottom = 15.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Box(
            modifier = Modifier
                .background(SecundarioDark)
                .padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            DockedSearchBar(
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .align(Alignment.TopCenter)
                    .padding(top = 8.dp).semantics {
                        traversalIndex = 0f
                    },
                inputField = {
                    SearchBarDefaults.InputField(
                        query = text,
                        onQueryChange = { text = it },
                        onSearch = { expanded = false },
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                        leadingIcon = {
                            Icon(
                                painterResource(Res.drawable.search),
                                contentDescription = null
                            )
                        }
                    )
                },
                shape = MaterialTheme.shapes.small,
                colors = SearchBarDefaults.colors(containerColor = Color.White),
                expanded = expanded,
                onExpandedChange = { expanded = it },
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    repeat(4) { idx ->
                        var color by remember { mutableStateOf(NeutralDarkest) }
                        var backgroundColor by remember { mutableStateOf(Color.Transparent) }

                        val resultText = "Suggestion $idx"
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(backgroundColor)
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = {
                                            try {
                                                backgroundColor = Color(0xFFFBFBFB)
                                                color = PrimarioMedium
                                                awaitRelease()
                                            } finally {
                                                color = NeutralDarkest
                                                backgroundColor = Color.Transparent
                                                text = resultText
                                                expanded = false
                                                onAction(SearchAction.OnSearchResultClick(resultText))
                                            }
                                        }
                                    )
                                }
                                .padding(horizontal = 30.dp, vertical = 18.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Text(
                                text = resultText,
                                color = color,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        HorizontalDivider(color = Color(0xFFD9DADB))
                    }
                }
            }
        }

        isNotFounds?.let { notFound ->
            Text(
                text = "No encontramos resultados para tu búsqueda de “$notFound”.",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}