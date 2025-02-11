package com.tismart.apptismart.features.search.presentation

enum class SearchType(val title: String, val description: String? = null) {
    VACANCIES(title = "Busca nuevas vacantes", description = "¡Descubre nuevas oportunidades! Explora vacantes internas y sigue el progreso de tus postulaciones. \uD83D\uDE80"),
    COURSES(title = "Explora nuevos cursos"),
    BENEFITS(title = "Descubre tus beneficios")
}