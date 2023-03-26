package com.razaghimahdi.raininglightsanimation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.razaghimahdi.raininglightsanimation.R


private val OrbitronFontFamily = FontFamily(
    Font(R.font.orbitron_light, FontWeight.W300),
    Font(R.font.orbitron, FontWeight.W400),
    Font(R.font.orbitron_bold, FontWeight.W600),
    Font(R.font.orbitron_black, FontWeight.W800),
)

val OrbitronTypography = Typography(
    h1 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp,
    ),
    h2 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W300,
        fontSize = 30.sp,
    ),
    h3 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W300,
        fontSize = 20.sp,
    ),
    h4 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
    ),
    h5 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
    ),
    h6 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
    ),
    caption = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = OrbitronFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)




// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)