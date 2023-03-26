package com.razaghimahdi.raininglightsanimation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.razaghimahdi.raininglightsanimation.R
import com.razaghimahdi.raininglightsanimation.model.Planet
import com.razaghimahdi.raininglightsanimation.model.planets
import com.razaghimahdi.raininglightsanimation.ui.component.CustomButton
import com.razaghimahdi.raininglightsanimation.ui.component.NewsCard
import com.razaghimahdi.raininglightsanimation.ui.component.PlanetItem
import com.razaghimahdi.raininglightsanimation.ui.component.TabLayout
import com.razaghimahdi.raininglightsanimation.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun MainScreen(onClick: (Planet) -> Unit) {

    val plantList = remember { mutableStateOf(planets) }


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (
            topBackground, bottomBackground,
            menuIcon, searchIcon,
            welcomeTitle,
            tabLayoutMenu,
            lazyRowPlanet,
            newsTitle, newsCard,
        ) = createRefs()

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


        val topGuideline = createGuidelineFromTop(16.dp)

        createHorizontalChain(menuIcon, searchIcon, chainStyle = ChainStyle.SpreadInside)


        CustomButton(
            image = R.drawable.menu,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(menuIcon) {
                    top.linkTo(topGuideline)
                })

        CustomButton(
            image = R.drawable.search,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(searchIcon) {
                    top.linkTo(menuIcon.top)
                    bottom.linkTo(menuIcon.bottom)
                })



        Text(text = "welcome!",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .constrainAs(welcomeTitle) {
                    top.linkTo(menuIcon.bottom)
                    start.linkTo(parent.start)
                })


        TabLayout(
            this, tabLayoutMenu, welcomeTitle, listOf(
                "all",
                "planets",
                "comets",
                "stars",
                "satellites",
            )
        )


        LazyRow(
            modifier = Modifier
                .constrainAs(lazyRowPlanet) {
                    top.linkTo(tabLayoutMenu.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {

            items(plantList.value) { planet ->
                PlanetItem(planet){
                    onClick(planet)
                }
            }
        }



        Text(text = "astronomical news",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .constrainAs(newsTitle) {
                    top.linkTo(lazyRowPlanet.bottom)
                    start.linkTo(parent.start)
                })



        NewsCard(this, newsCard, newsTitle)





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

