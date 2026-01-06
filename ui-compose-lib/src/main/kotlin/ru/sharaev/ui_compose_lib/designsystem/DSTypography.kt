package ru.sharaev.ui_compose_lib.designsystem

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.sharaev.ui_compose_lib.R

private val DSFontFamily = FontFamily(
    Font(R.font.manrope_extra_light, FontWeight.ExtraLight),
    Font(R.font.manrope_light, FontWeight.Light),
    Font(R.font.manrope_regular, FontWeight.Normal),
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_semi_bold, FontWeight.SemiBold),
    Font(R.font.manrope_bold, FontWeight.Bold),
    Font(R.font.manrope_extra_bold, FontWeight.ExtraBold),
)

@Composable
fun DSTypography(colorScheme: ColorScheme) = Typography(
    titleLarge = TextStyle(
        fontFamily = DSFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        color = colorScheme.onSurface,
    ),
    titleMedium = TextStyle(
        fontFamily = DSFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = colorScheme.onSurface,
    ),
    titleSmall = TextStyle(
        fontFamily = DSFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        color = colorScheme.onSurface,
    ),
    headlineMedium = TextStyle(
        fontFamily = DSFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        color = colorScheme.onSurface,
    ),
    bodyLarge = TextStyle(
        fontFamily = DSFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        color = colorScheme.onSurface,
    ),
    bodySmall = TextStyle(
        fontFamily = DSFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
        color = colorScheme.onSurface,
    ),
)
