package com.razaghimahdi.raininglightsanimation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.razaghimahdi.raininglightsanimation.ui.theme.ButtonColor


@Composable
fun NewsCard(
    constraintLayoutScope: ConstraintLayoutScope,
    newsCard: ConstrainedLayoutReference,
    newsTitle: ConstrainedLayoutReference
) {
    constraintLayoutScope.apply {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(ButtonColor, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .constrainAs(newsCard) {
                    top.linkTo(newsTitle.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        ) {


            Text(
                text = "The Sky This Week: Conjunctions galore!",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 4.dp, top = 8.dp)
            )




            Text(
                text = "Uranus glows a dim magnitude 5.9 and you’ll need binoculars or a telescope to easily pick out the distant ice giant just south of a 14-percent-lit lunar crescent. The planet sits very close (within 4') to a 7th-magnitude field star that will pop out in your optics to Uranus’ southeast. The planet is slightly brighter — note that its disk will appear more like a “flat” star than a pinprick of light, and may even display a grayish-blue coloration.",
                style = MaterialTheme.typography.overline,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp)
            )


        }
    }
}