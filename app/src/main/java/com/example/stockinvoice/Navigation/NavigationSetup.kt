package com.example.stockinvoice.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stockinvoice.Screens.LoginScreen
import com.example.stockinvoice.Screens.RegisterScreen
import com.example.stockinvoice.Screens.SplashScreen


@Composable
fun Navgraph(Navcontro:NavHostController) {


    NavHost(navController = Navcontro, startDestination = routes.splash.route) {

        composable(route = routes.splash.route) {
            SplashScreen(Navcontro)
        }


        composable(route = routes.login.route) {
           LoginScreen(Navcontro)
        }

        composable(route = routes.register.route) {
          RegisterScreen(Navcontro)
        }
    }
}