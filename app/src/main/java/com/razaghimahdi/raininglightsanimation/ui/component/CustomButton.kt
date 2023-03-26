package com.razaghimahdi.raininglightsanimation.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.razaghimahdi.raininglightsanimation.ui.theme.ButtonColor
import com.razaghimahdi.raininglightsanimation.ui.theme.ButtonContentColor


@Composable
fun CustomButton(onClick: () -> Unit={},image: Int, modifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor, contentColor = ButtonContentColor),
        onClick = onClick,
        modifier = modifier
            .size(55.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        // your button content here, for example:
        Icon(painterResource(image), null)
    }
}