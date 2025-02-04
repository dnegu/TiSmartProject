package com.tismart.apptismart.features.news.presentation.news_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NewsListViewModel(

) : ViewModel() {

    var state by mutableStateOf(NewsListState())
        private set

    fun onAction(action: NewsListAction) {

    }
}