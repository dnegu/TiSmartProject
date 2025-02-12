package com.tismart.apptismart.features.news.presentation.news_detail

import org.jetbrains.compose.resources.DrawableResource
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.news_card

data class NewsDetailState(
    val image: DrawableResource = Res.drawable.news_card,
    val title: String = "Teletrabajo del 11 al 13 de noviembre",
    val description: String = "El Gobierno dispuso este viernes que los trabajadores del sector público de Lima Metropolitana, la provincia de Huaral y la provincia Constitucional del Callao realice teletrabajo los días lunes 11 martes 12 y miércoles 13 de noviembre del 2024.\n\nEllo con motivo de la realización de la Cumbre del Foro de Cooperación Económica Asia-Pacífico (APEC). Al respecto, Franco Muschi, socio del Departamento Laboral de Garrigues, comentó a Gestión sobre las opciones que tienen los empleadores y trabajadores en este contexto."
)