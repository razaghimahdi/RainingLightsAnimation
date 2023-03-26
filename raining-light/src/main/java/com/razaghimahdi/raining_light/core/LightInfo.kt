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

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp


internal data class LightInfo(
    var x: Dp,
    var y: Dp,
    val height: Dp,
    val thickness: Dp,
    val brush: Brush,
    val headColor: Brush?,
)
