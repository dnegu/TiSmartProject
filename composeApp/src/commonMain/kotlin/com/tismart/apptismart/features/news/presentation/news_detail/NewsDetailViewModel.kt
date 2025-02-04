package com.tismart.apptismart.features.news.presentation.news_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NewsDetailViewModel(

) : ViewModel() {

    var state by mutableStateOf(NewsDetailState())
        private set

    fun onAction(action: NewsDetailAction) {

    }
}