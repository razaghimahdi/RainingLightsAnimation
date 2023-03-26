package com.razaghimahdi.raininglightsanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.razaghimahdi.raining_light.RainingLightsBox
import com.razaghimahdi.raininglightsanimation.screen.DetailScreen
import com.razaghimahdi.raininglightsanimation.screen.MainScreen
import com.razaghimahdi.raininglightsanimation.ui.navigation.ScreenNavigation
import com.razaghimahdi.raininglightsanimation.ui.theme.RainingLightsAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()


            RainingLightsAnimationTheme {


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RainingLightsBox(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colors.background)
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = ScreenNavigation.Main.route
                        ) {
                            composable(ScreenNavigation.Main.route) {
                                MainScreen {
                                    navController.navigate("${ScreenNavigation.Detail.route}/${it.id}")
                                }
                            }
                            composable(ScreenNavigation.Detail.route + "/{id}",
                                ScreenNavigation.Detail.arguments,)
                            {backStackEntry->
                                DetailScreen(backStackEntry.arguments?.getInt("id")!!){
                                    navController.popBackStack()
                                }
                            }

                        }


                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        hideUISystem()
    }

    private fun hideUISystem() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}
