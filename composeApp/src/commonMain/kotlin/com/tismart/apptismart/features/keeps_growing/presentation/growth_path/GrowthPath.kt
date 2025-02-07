package com.tismart.apptismart.features.keeps_growing.presentation.growth_path

sealed class GrowthPath(
    val title: String,
    val description: String,
    val softSkillsCourses: List<String>,
    val hardSkillsCourses: List<String>
) {
    data object SemiSenior : GrowthPath(
        title = "Developer Semi Senior",
        description = "Es un programador en formación que escribe código básico, corrige errores y asiste en proyectos.\n\nSi deseas desarrollarte como un Developer Semi Senior, te recomendamos llevar estos cursos y conseguir las habilidades para tu siguiente nivel! \uD83C\uDF1F",
        softSkillsCourses = listOf(
            "Comunicación efectiva",
            "Trabajo en equipo y colaboración",
            "Adaptabilidad y gestión del cambio",
            "Liderazgo y delegación"
        ),
        hardSkillsCourses = listOf(
            "Lenguaje de Programación\n\t- Python\n\t- Java\n\t- JavaScript",
            "Git",
            "Datos para IA"
        )
    )
    data object FullStack : GrowthPath(
        title = "Full Stack Developer",
        description = "Desarrollador Full Stack en formación, construye y mantiene aplicaciones web completas, manejando frontend y backend.\n\nSi quieres avanzar al nivel Semi Senior, estos cursos te ayudarán a fortalecer tus habilidades y dar el siguiente paso en tu carrera. ¡Prepárate para crecer! \uD83C\uDF1F",
        softSkillsCourses = listOf(
            "Comunicación efectiva",
            "Trabajo en equipo y colaboración",
            "Adaptabilidad y gestión del cambio",
            "Liderazgo y delegación"
        ),
        hardSkillsCourses = listOf(
            "HTML, CSS y JavaScript avanzado: Profundiza en los fundamentos del frontend.",
            "Frameworks de JavaScript (React, Angular, Vue): Aprende a trabajar con frameworks modernos.",
            "Responsive Design: Mejora en el diseño adaptable a dispositivos móviles."
        )
    )
}
