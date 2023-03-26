package com.razaghimahdi.raininglightsanimation.model

import com.razaghimahdi.raininglightsanimation.R

data class Planet(
    val id:Int,
    val name: String,
    val description: String,
    val distance: String,
    val type: String,
    val image: Int
)


val planets = listOf(

    Planet(
        id = 0,
        name = "Earth",
        description = "Earth—our home planet—is the only place we know of so far that’s inhabited by living things. It's also the only planet in our solar system with liquid water on the surface.",
        distance = "92,693,873 KM",
        type="Terrestrial",
        image = R.drawable.earth
    ),

    Planet(
        id = 1,
        name = "Mars",
        description = "Mars is a dusty, cold, desert world with a very thin atmosphere. There is strong evidence Mars was – billions of years ago – wetter and warmer, with a thicker atmosphere.\n",
        distance = "152,864,345 KM",
        type = "Terrestrial",
        image =R.drawable.mars
    ),


    Planet(
        id = 2,
        name = "Saturn",
        description = "Adorned with a dazzling, complex system of icy rings, Saturn is unique in our solar system. The other giant planets have rings, but none are as spectacular as Saturn's.\n",
        distance = "912,287,199 KM",
        type = "Gas Giant",
        image =R.drawable.saturn
    ),


    Planet(
        id = 3,
        name = "Neptune",
        description = "Neptune—the eighth and most distant major planet orbiting our Sun—is dark, cold and whipped by supersonic winds. It was the first planet located through mathematical calculations.\n",
        distance = "2,780,363,174 KM",
        type = "Ice Giant",
        image =R.drawable.neptune
    ),

)
