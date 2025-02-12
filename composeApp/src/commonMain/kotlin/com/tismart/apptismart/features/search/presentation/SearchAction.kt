package com.tismart.apptismart.features.search.presentation

sealed interface SearchAction {
    data object OnProfileClick : SearchAction
    data object OnNotificationsClick : SearchAction
    data object OnBackClick : SearchAction
    data class OnSearchResultClick(val result: String) : SearchAction
}