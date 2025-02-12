package com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors

data class MentorApplicationFormError(
    val area: Boolean = false,
    val currentPosition: Boolean = false,
    val experience: Boolean = false,
    val motivation: Boolean = false,
    val cv: Boolean = false
)