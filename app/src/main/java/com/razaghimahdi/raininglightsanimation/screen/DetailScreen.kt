package com.razaghimahdi.raininglightsanimation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.razaghimahdi.raininglightsanimation.R
import com.razaghimahdi.raininglightsanimation.model.Planet
import com.razaghimahdi.raininglightsanimation.model.planets
import com.razaghimahdi.raininglightsanimation.ui.component.CustomButton
import com.razaghimahdi.raininglightsanimation.ui.component.TabLayout
import com.razaghimahdi.raininglightsanimation.ui.theme.*


@Composable
fun DetailScreen(id:Int, backPressed:()->Unit) {

    val planet = planets.find { it.id==id }!!


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (
            topBackground, bottomBackground,
            backIcon,
            overviewTitle,
            tabLayoutMenu,
            imagePlanet,
            namePlanet,
            typeTitle, typePlanet,
            distanceTitle, distancePlanet
        ) = createRefs()

        val topGuideline = createGuidelineFromTop(16.dp)

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        grey_1000_b,
                        grey_1000,
                        grey_1500,
                        transparent
                    ), startY = 15f
                )
            )
            .constrainAs(topBackground) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            })


        CustomButton(
            onClick=backPressed,
            image = R.drawable.arrow_left,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(backIcon) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                })


        Text(text = "overview",
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(overviewTitle) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })


        TabLayout(
            this, tabLayoutMenu, overviewTitle, listOf(
                "360",
                "information",
                "gallery",
            )
        )


        Image(
            painterResource(id = planet.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .constrainAs(imagePlanet) {
                    top.linkTo(tabLayoutMenu.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )



        Text(text = planet.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(namePlanet) {
                    top.linkTo(imagePlanet.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })




        Text(text = "type",
            style = MaterialTheme.typography.h6,
            color = ButtonContentColor,
            modifier = Modifier
                .padding(top = 32.dp)
                .constrainAs(typeTitle) {
                    top.linkTo(namePlanet.bottom)
                    start.linkTo(distanceTitle.end)
                    end.linkTo(parent.end)
                })

        Text(text = planet.type,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(typePlanet) {
                    top.linkTo(typeTitle.bottom)
                    start.linkTo(typeTitle.start)
                    end.linkTo(typeTitle.end)
                })



        Text(text = "distance from sun",
            style = MaterialTheme.typography.h6,
            color = ButtonContentColor,
            modifier = Modifier
                .padding(top = 32.dp)
                .constrainAs(distanceTitle) {
                    top.linkTo(namePlanet.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(typeTitle.start)
                })


        Text(text = planet.distance,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(distancePlanet) {
                    top.linkTo(distanceTitle.bottom)
                    start.linkTo(distanceTitle.start)
                    end.linkTo(distanceTitle.end)
                })




        Box(modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        transparent,
                        grey_1500,
                        grey_1000,
                        grey_1000_b
                    ), endY = 150f
                )
            )
            .constrainAs(bottomBackground) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            })

    }
}