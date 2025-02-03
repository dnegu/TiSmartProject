package com.tismart.apptismart.core.presentation

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.poppins_black
import tismartproject.composeapp.generated.resources.poppins_blackItalic
import tismartproject.composeapp.generated.resources.poppins_bold
import tismartproject.composeapp.generated.resources.poppins_boldItalic
import tismartproject.composeapp.generated.resources.poppins_extraBold
import tismartproject.composeapp.generated.resources.poppins_extraBoldItalic
import tismartproject.composeapp.generated.resources.poppins_extraLight
import tismartproject.composeapp.generated.resources.poppins_extraLightItalic
import tismartproject.composeapp.generated.resources.poppins_italic
import tismartproject.composeapp.generated.resources.poppins_light
import tismartproject.composeapp.generated.resources.poppins_medium
import tismartproject.composeapp.generated.resources.poppins_mediumItalic
import tismartproject.composeapp.generated.resources.poppins_regular
import tismartproject.composeapp.generated.resources.poppins_semiBold
import tismartproject.composeapp.generated.resources.poppins_semiBoldItalic
import tismartproject.composeapp.generated.resources.poppins_thin
import tismartproject.composeapp.generated.resources.poppins_thinItalic

@Composable
fun PoppinsFontFamily() = FontFamily(
    Font(Res.font.poppins_thin, weight = FontWeight.Thin),
    Font(Res.font.poppins_thinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(Res.font.poppins_extraLight, weight = FontWeight.ExtraLight),
    Font(Res.font.poppins_extraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(Res.font.poppins_light, weight = FontWeight.Light),
    Font(Res.font.poppins_light, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.poppins_regular, weight = FontWeight.Normal),
    Font(Res.font.poppins_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.poppins_medium, weight = FontWeight.Medium),
    Font(Res.font.poppins_mediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.poppins_semiBold, weight = FontWeight.SemiBold),
    Font(Res.font.poppins_semiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(Res.font.poppins_bold, weight = FontWeight.Bold),
    Font(Res.font.poppins_boldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.poppins_extraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.poppins_extraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(Res.font.poppins_black, weight = FontWeight.Black),
    Font(Res.font.poppins_blackItalic, weight = FontWeight.Black, style = FontStyle.Italic)
)

@Composable
fun PoppinsTypography() = Typography().run {

    val fontFamily = PoppinsFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}