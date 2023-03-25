package com.razaghimahdi.raininglightsanimation.ui.core

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp


data class LightInfo(
    var x: Dp,
    var y: Dp,
    val height: Dp,
    val thickness: Dp,
    val brush: Brush,
    val headColor: Brush?,
)
