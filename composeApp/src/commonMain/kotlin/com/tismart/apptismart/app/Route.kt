package com.tismart.apptismart.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object HomeGraph: Route

    @Serializable
    data object NewsList: Route

    @Serializable
    data class NewsDetail(val id: String): Route
}