package com.razaghimahdi.raininglightsanimation

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.razaghimahdi.raininglightsanimation.ui.theme.RandomColor
import com.razaghimahdi.raininglightsanimation.ui.theme.grey_500
import com.razaghimahdi.raininglightsanimation.ui.theme.grey_700
import com.razaghimahdi.raininglightsanimation.ui.theme.grey_900
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RainingLightsAnimation() {
    val lightInfos = remember { mutableStateListOf<LightInfo>() }

    val destiny = LocalDensity.current

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp.toPx()
    val lightInfos2 = rememberUpdatedState(newValue = lightInfos)

    LaunchedEffect(Unit) {
        while (true) {
            delay((50..150).random().toLong())
            val id = if (lightInfos2.value.isEmpty()) 0 else lightInfos2.value.last().id + 1
            lightInfos2.value.add(
                LightInfo(
                    id = id,
                    x = with(destiny) { (0..screenWidth.toInt()).random().toDp() },
                    y = 0.dp,
                    height = configuration.screenHeightDp.dp / 4,
                    thickness = 1.dp,
                    brush = Brush.linearGradient(listOf(grey_900, grey_700, grey_500)),
                    headColor = null
                )
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(1000)
        while (true) {
            delay((50..100).random().toLong())
            val colors = RandomColor.randomColors()
            val id = if (lightInfos2.value.isEmpty()) 0 else lightInfos2.value.last().id + 1
            lightInfos2.value.add(
                LightInfo(
                    id = id,
                    x = with(destiny) { (0..screenWidth.toInt()).random().toDp() },
                    y = 0.dp,
                    height = configuration.screenHeightDp.dp / 4,
                    thickness = 3.dp,
                    brush = Brush.linearGradient(colors),
                    headColor = Brush.radialGradient(RandomColor.getHeadOfRandomColor(colors))
                )
            )
        }
    }




    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val lightInfosCopy = lightInfos2.value.toList() // Create a copy of the original list


        lightInfosCopy.forEach { light ->
            val startValue = -(light.height.toPx())
            val endValue = (screenHeight + light.height).toPx()

            val yPosition = remember { Animatable(startValue) }

            LaunchedEffect(yPosition) {
                launch {
                    yPosition.animateTo(
                        endValue,
                        animationSpec = tween(3000),
                    )
                }
            }

            light.y = yPosition.value.toDp()
            if (light.y.toPx() < endValue) {
                MainLight(
                    LightInfo(
                        id = light.id,
                        x = light.x,
                        y = light.y,
                        height = light.height,
                        thickness = light.thickness,
                        brush = light.brush,
                        headColor = light.headColor
                    )
                )
            } else {
                //  lightInfos.removeAt(index)
               // lightInfos2.value.remove(light)
                Log.i("TAG", "RainingLightsAnimation  lightInfos.removeAt(index):  ")
            }

            /*   if (light.y.toPx() == endValue) {
                  /* val newItems = lights
                   newItems.removeAt(index)
                   //newItems.clear()
                   lights = newItems*/
                  //Log.i("TAG", "RainingLightsAnimation light.y==endValue: ")
                 // lights.removeAt(index)
                  // lights.filter { it.y.toPx()==endValue }
                   lightInfos2.value.remove(light)
              }*/

        }
        /*if (lights.size>50){
            lights.removeRange(0,20)
        }*/
        Log.i("TAG", "RainingLightsAnimation lights: " + lightInfos2.value.size)
    }

}

data class LightInfo(
    val id: Long,
    var x: Dp,
    var y: Dp,
    val height: Dp,
    val thickness: Dp,
    val brush: Brush,
    val headColor: Brush?,
)

@Composable
fun BackgroundLight(lightInfo: LightInfo) {
    Divider(
        modifier = Modifier
            .height(lightInfo.height)
            .width(lightInfo.thickness)
            .offset(lightInfo.x, lightInfo.y)
            .background(brush = lightInfo.brush),
        thickness = lightInfo.thickness
    )
}

@Composable
fun MainLight(lightInfo: LightInfo) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .offset(lightInfo.x, lightInfo.y),
        contentAlignment = Alignment.BottomCenter
    ) {

        val headSize = lightInfo.thickness * 3

        Divider(
            modifier = Modifier
                .height(lightInfo.height)
                .width(lightInfo.thickness)
                .padding(bottom = headSize / 2)
                .background(brush = lightInfo.brush),
            thickness = lightInfo.thickness
        )

        lightInfo.headColor?.let {
            Box(
                Modifier
                    .size(headSize)
                    .background(it, CircleShape)
                    .clip(CircleShape)
                    .shadow(
                        elevation = 16.dp,
                        shape = CircleShape,
                    )
            )
        }
    }
}


@Composable
fun Dp.toPx() = with(LocalDensity.current) { this@toPx.toPx() }

@Composable
fun Int.toDp() = with(LocalDensity.current) { this@toDp.toDp() }

@Composable
fun Float.toDp() = with(LocalDensity.current) { this@toDp.toDp() }
