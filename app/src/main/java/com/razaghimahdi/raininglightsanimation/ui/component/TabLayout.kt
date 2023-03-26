package com.razaghimahdi.raininglightsanimation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.razaghimahdi.raininglightsanimation.ui.theme.ButtonContentColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
    constraintLayoutScope: ConstraintLayoutScope,
    tabLayoutMenu: ConstrainedLayoutReference,
    welcomeTitle: ConstrainedLayoutReference,
    list: List<String>
) {
    val pagerState = rememberPagerState(pageCount = list.size)

    val scope = rememberCoroutineScope()

    constraintLayoutScope.apply {

        ScrollableTabRow(
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(tabLayoutMenu) {
                    top.linkTo(welcomeTitle.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color.Transparent,
            contentColor = Color.Transparent,
            edgePadding = if (list.size < 4) 32.dp else 0.dp,
            divider = {},
            indicator = { tabPositions ->

                Divider(
                    color = ButtonContentColor,
                    modifier = Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                    thickness = 2.dp
                )
            }
        ) {
            list.forEachIndexed { index, _ ->
                Tab(
                    icon = {

                    },
                    text = {
                        Text(
                            list[index],
                            style = MaterialTheme.typography.h5,
                            color = if (pagerState.currentPage == index) ButtonContentColor else MaterialTheme.colors.onBackground
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }


    }
}

