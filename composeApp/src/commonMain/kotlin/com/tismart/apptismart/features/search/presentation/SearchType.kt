package com.tismart.apptismart.features.search.presentation

import androidx.core.bundle.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.json.Json

enum class SearchType(val title: String, val description: String? = null) {
    VACANCIES(title = "Busca nuevas vacantes", description = "¡Descubre nuevas oportunidades! Explora vacantes internas y sigue el progreso de tus postulaciones. \uD83D\uDE80"),
    COURSES(title = "Explora nuevos cursos"),
    BENEFITS(title = "Descubre tus beneficios")
}

class SearchTypeNavType : NavType<SearchType>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): SearchType? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): SearchType {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: SearchType) {
        bundle.putString(key, Json.encodeToString(value))
    }
}