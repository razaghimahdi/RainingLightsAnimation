package com.razaghimahdi.raininglightsanimation.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random


object RandomColor {

    val list1 = listOf(
        grey_1000, grey_700, grey_500
    )

    val list2 = listOf(
        cyan_1000,
        cyan_900,
        cyan_500,
        cyan_400,
        cyan_300,
        cyan_200,
        cyan_100,
    )

    val list3 = listOf(
        light_blue_1000,
        light_blue_900,
        light_blue_500,
        light_blue_400,
        light_blue_300,
        light_blue_200,
        light_blue_100,
    )

    fun randomColors(): List<Color> {

        val randomColors = listOf(
            list1,
            list2,
            list3,
        )
        val randomIndex = Random.nextInt(randomColors.size);
        val randomElement = randomColors[randomIndex]
        return randomElement
    }


    fun getHeadOfRandomColor(list: List<Color>): List<Color> {
        return when (list) {
            list1 -> {
                listOf(
                    grey_500,
                    grey_600.copy(.9f),
                    grey_700.copy(.3f)
                )
            }
            list2 -> {
                listOf(
                    cyan_300,
                    cyan_200.copy(.9f),
                    cyan_100.copy(.6f),
                    cyan_050.copy(.3f),
                )
            }
            list3 -> {
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


val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val light_blue_050 = Color(0xFFe1f5fe)
val light_blue_100 = Color(0xFFb3e5fc)
val light_blue_200 = Color(0xFF81d4fa)
val light_blue_300 = Color(0xFF4fc3f7)
val light_blue_400 = Color(0xFF29b6f6)
val light_blue_500 = Color(0xFF03A9F4)
val light_blue_600 = Color(0xFF039be5)
val light_blue_700 = Color(0xFF0288D1)
val light_blue_800 = Color(0xFF0277bd)
val light_blue_900 = Color(0xFF01579B)
val light_blue_1000 = Color(0x80032846)
val light_blue_a100 = Color(0xFF80d8ff)
val light_blue_a200 = Color(0xFF40c4ff)
val light_blue_a400 = Color(0xFF00b0ff)
val light_blue_a700 = Color(0xFF0091ea)


val cyan_050 = Color(0xFFe0f7fa)
val cyan_100 = Color(0xFFb2ebf2)
val cyan_200 = Color(0xFF80deea)
val cyan_300 = Color(0xFF4dd0e1)
val cyan_400 = Color(0xFF26c6da)
val cyan_500 = Color(0xFF00BCD4)
val cyan_600 = Color(0xFF00acc1)
val cyan_700 = Color(0xFF0097A7)
val cyan_800 = Color(0xFF00838f)
val cyan_900 = Color(0xFF006064)
val cyan_1000 = Color(0x80012E30)
val cyan_a100 = Color(0xFF84ffff)
val cyan_a200 = Color(0xFF18ffff)
val cyan_a400 = Color(0xFF00e5ff)
val cyan_a700 = Color(0xFF00b8d4)

val grey_050 = Color(0xFFfafafa)
val grey_100 = Color(0xFFf5f5f5)
val grey_200 = Color(0xFFeeeeee)
val grey_300 = Color(0xFFe0e0e0)
val grey_400 = Color(0xFFbdbdbd)
val grey_500 = Color(0xFF9E9E9E)
val grey_600 = Color(0xFF757575)
val grey_700 = Color(0xFF616161)
val grey_800 = Color(0xFF424242)
val grey_900 = Color(0xFF212121)
val grey_1000 = Color(0x80131313)
val grey_1000_b = Color(0xFF000000)
val grey_1000_w = Color(0xFFffffff)




