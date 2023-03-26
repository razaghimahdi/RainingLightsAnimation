package com.razaghimahdi.raininglightsanimation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.razaghimahdi.raininglightsanimation.R
import com.razaghimahdi.raininglightsanimation.model.Planet
import com.razaghimahdi.raininglightsanimation.ui.theme.ButtonColor
import com.razaghimahdi.raininglightsanimation.ui.theme.ButtonContentColor


@Composable
fun PlanetItem(planet: Planet, onClick: (Planet) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    ConstraintLayout(
        modifier = Modifier
            .padding(8.dp)
            .height(280.dp)
            .width(280.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick(planet) },
            )
    ) {

        val (
            planetImage,
            detail,
        ) = createRefs()



        ConstraintLayout(modifier = Modifier
            .height(250.dp)
            .width(260.dp)
            .constrainAs(detail) {
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        ) {
            val (
                background,
                title,
                arrowIcon,
            ) = createRefs()



            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(ButtonColor, RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .constrainAs(background) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )

            createHorizontalChain(title, arrowIcon, chainStyle = ChainStyle.SpreadInside)




            Text(
                planet.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(title) {
                        bottom.linkTo(parent.bottom)
                    })

            Icon(
                painterResource(R.drawable.arrow_right),
                null,
                tint = ButtonContentColor,
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(arrowIcon) {
                        top.linkTo(title.top)
                        bottom.linkTo(title.bottom)
                    })


        }

        Image(
            painterResource(id = planet.image),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .constrainAs(planetImage) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })

    }
}
