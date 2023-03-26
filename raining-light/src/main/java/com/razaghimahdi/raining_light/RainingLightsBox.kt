package com.razaghimahdi.raining_light

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.razaghimahdi.raining_light.component.MainLight
import com.razaghimahdi.raining_light.core.*
import com.razaghimahdi.raining_light.core.LightInfo
import com.razaghimahdi.raining_light.core.toDp
import com.razaghimahdi.raining_light.core.toPx
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun RainingLightsBox(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    val lights = remember { mutableStateListOf<LightInfo>() }


    val destiny = LocalDensity.current

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp.toPx()

    LaunchedEffect(Unit) {
        while (true) {
            if (lights.size > 60) break

            val delay = 50..100
            delay(delay.random().toLong())

            lights.add(
                LightInfo(
                    x = with(destiny) { (0..screenWidth.toInt()).random().toDp() },
                    y = 0.dp,
                    height = configuration.screenHeightDp.dp / 4,
                    thickness = 1.dp,
                    brush = Brush.linearGradient(listOf(grey_900, grey_700, grey_500)),
                    headColor = null,
                )
            )
        }

    }

    LaunchedEffect(Unit) {

        delay(1000)
        while (true) {
            if (lights.size > 60) break

            val delay = 50..80
            delay(delay.random().toLong())
            val colors = RandomColor.randomColors()

            lights.add(
                LightInfo(
                    x = with(destiny) { (0..screenWidth.toInt()).random().toDp() },
                    y = 0.dp,
                    height = configuration.screenHeightDp.dp / 4,
                    thickness = 3.dp,
                    brush = Brush.linearGradient(colors),
                    headColor = Brush.radialGradient(RandomColor.getHeadOfRandomColor(colors)),
                )
            )
        }

    }



    lights.forEach { light ->
        val startValue = -(light.height.toPx())
        val endValue = (screenHeight + light.height).toPx()

        val yPosition = remember { Animatable(startValue) }

        LaunchedEffect(yPosition) {
            launch {
                yPosition.animateTo(
                    endValue,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = 3000,
                            easing = LinearOutSlowInEasing
                        ), repeatMode = RepeatMode.Restart
                    ),
                )
            }
        }

        light.y = yPosition.value.toDp()

    }



    StatelessScreen(
        list = lights,
        modifier = modifier,
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints,
        content = content
    )

}

@Composable
private fun StatelessScreen(
    list: List<LightInfo>,
    modifier: Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {


    Box(modifier, contentAlignment, propagateMinConstraints) {

        list.forEach { light ->
            MainLight(
                LightInfo(
                    x = light.x,
                    y = light.y,
                    height = light.height,
                    thickness = light.thickness,
                    brush = light.brush,
                    headColor = light.headColor,
                )
            )
        }

        content()


    }

}

