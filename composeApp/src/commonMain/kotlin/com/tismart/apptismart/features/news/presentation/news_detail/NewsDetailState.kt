package com.tismart.apptismart.features.news.presentation.news_detail

import org.jetbrains.compose.resources.DrawableResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.news_card

data class NewsDetailState(
    val image: DrawableResource = Res.drawable.news_card,
    val title: String = "",
    val description: String = ""
)