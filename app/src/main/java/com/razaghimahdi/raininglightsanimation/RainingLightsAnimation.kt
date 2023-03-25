package com.razaghimahdi.raininglightsanimation

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.razaghimahdi.raininglightsanimation.ui.component.MainLight
import com.razaghimahdi.raininglightsanimation.ui.core.LightInfo
import com.razaghimahdi.raininglightsanimation.ui.core.toDp
import com.razaghimahdi.raininglightsanimation.ui.core.toPx
import com.razaghimahdi.raininglightsanimation.ui.theme.RandomColor
import com.razaghimahdi.raininglightsanimation.ui.theme.grey_500
import com.razaghimahdi.raininglightsanimation.ui.theme.grey_700
import com.razaghimahdi.raininglightsanimation.ui.theme.grey_900
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun RainingLightsAnimation() {
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



    lights.forEachIndexed { index, light ->
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
        if (light.y.toPx() == endValue) light.x =
            with(destiny) { (0..screenWidth.toInt()).random().toDp() }


    }



    StatelessScreen(list = lights)

}

@Composable
fun StatelessScreen(list: List<LightInfo>) {


    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

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
    }

}

