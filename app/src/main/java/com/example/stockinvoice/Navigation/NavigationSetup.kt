package com.example.stockinvoice.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stockinvoice.Screens.SplashScreen
import com.example.stockinvoice.Screens.TermsAndConditionsScreen
import com.example.stockinvoice.Screens.signInScreen.LogInScreen
import com.example.stockinvoice.Screens.signInScreen.SignUpPage


@Composable
fun Navgraph(navController: NavHostController) {

    var startDestination = routes.splash.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = routes.splash.route) {
            SplashScreen(navController)
        }


        composable(route = routes.login.route) {
            LogInScreen(navController)
            startDestination = routes.login.route
        }

        composable(route = routes.register.route) {
            SignUpPage(navController)
        }
        composable(route = routes.terms.route){
            TermsAndConditionsScreen(navController)
        }
    }
}
