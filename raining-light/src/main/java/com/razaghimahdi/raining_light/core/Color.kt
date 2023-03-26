/*
 * Copyright (C) 2023 razaghimahdi (Mahdi Razzaghi Ghaleh)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.razaghimahdi.raining_light.core

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object RandomColor {

    private val greyColorList = listOf(
        grey_1000, grey_700, grey_500
    )

    private val cyanColorList = listOf(
        cyan_1000,
        cyan_900,
        cyan_500,
        cyan_400,
        cyan_300,
        cyan_200,
        cyan_100,
    )

    private val lightBlueColorList = listOf(
        light_blue_1000,
        light_blue_900,
        light_blue_500,
        light_blue_400,
        light_blue_300,
        light_blue_200,
        light_blue_100,
    )

    internal fun randomColors(
        randomColors: List<List<Color>> = listOf(
            greyColorList,
            cyanColorList,
            lightBlueColorList,
        )
    ): List<Color> {
        val randomIndex = Random.nextInt(randomColors.size);
        val randomElement = randomColors[randomIndex]
        return randomElement
    }


    internal fun getHeadOfRandomColor(list: List<Color>): List<Color> {
        return when (list) {
            greyColorList -> {
                listOf(
                    grey_500,
                    grey_600.copy(.9f),
                    grey_700.copy(.3f)
                )
            }
            cyanColorList -> {
                listOf(
                    cyan_300,
                    cyan_200.copy(.9f),
                    cyan_100.copy(.6f),
                    cyan_050.copy(.3f),
                )
            }
            lightBlueColorList -> {
                listOf(
                    light_blue_300,
                    light_blue_200.copy(.9f),
                    light_blue_100.copy(.6f),
                    light_blue_050.copy(.3f),
                )
            }
            else -> {
                listOf(grey_900, grey_700, grey_500)
            }
        }

    }


}

internal val light_blue_050 = Color(0xFFe1f5fe)
internal val light_blue_100 = Color(0xFFb3e5fc)
internal val light_blue_200 = Color(0xFF81d4fa)
internal val light_blue_300 = Color(0xFF4fc3f7)
internal val light_blue_400 = Color(0xFF29b6f6)
internal val light_blue_500 = Color(0xFF03A9F4)
internal val light_blue_900 = Color(0xFF01579B)
internal val light_blue_1000 = Color(0x80032846)
internal val cyan_050 = Color(0xFFe0f7fa)
internal val cyan_100 = Color(0xFFb2ebf2)
internal val cyan_200 = Color(0xFF80deea)
internal val cyan_300 = Color(0xFF4dd0e1)
internal val cyan_400 = Color(0xFF26c6da)
internal val cyan_500 = Color(0xFF00BCD4)
internal val cyan_900 = Color(0xFF006064)
internal val cyan_1000 = Color(0x80012E30)
internal val grey_500 = Color(0xFF9E9E9E)
internal val grey_600 = Color(0xFF757575)
internal val grey_700 = Color(0xFF616161)
internal val grey_900 = Color(0xFF212121)
internal val grey_1000 = Color(0x80131313)