package com.example.stockinvoice.Screens

import android.widget.Toast
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.stockinvoice.R
import com.example.stockinvoice.ViewModels.authVM
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
val vm:authVM= viewModel()
    val firebaseUser by vm.firebaseUser.observeAsState(null)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.company_logo),
            contentDescription = "company Logo",
            modifier = Modifier.size(200.dp))
    }

val context= LocalContext.current
    LaunchedEffect(key1 = true) {
        delay(3000)

        if (firebaseUser != null) {
            navController.navigate("bottomNav") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }else{
            Toast.makeText(context,"please login first",Toast.LENGTH_SHORT).show()
                navController.navigate("login") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }


    }



}