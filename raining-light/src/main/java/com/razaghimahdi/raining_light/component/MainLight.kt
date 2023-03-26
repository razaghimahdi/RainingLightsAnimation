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
package com.razaghimahdi.raining_light.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.razaghimahdi.raining_light.core.LightInfo


@Composable
internal fun MainLight(lightInfo:()-> LightInfo) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .offset(lightInfo().x, lightInfo().y),
        contentAlignment = Alignment.BottomCenter
    ) {

        val headSize = lightInfo().thickness * 3

        Divider(
            modifier = Modifier
                .height(lightInfo().height)
                .width(lightInfo().thickness)
                .padding(bottom = headSize / 2)
                .background(brush = lightInfo().brush),
            thickness = lightInfo().thickness
        )

        lightInfo().headColor?.let {
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
