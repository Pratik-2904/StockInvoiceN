package com.example.stockinvoice.Screens

import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stockinvoice.R
import com.example.stockinvoice.ViewModels.authVM
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val vm: authVM = viewModel()
    val firebaseUser by vm.firebaseUser.observeAsState(null)
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

//    Splash()

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        delay(3000)

        if (firebaseUser != null) {
            navController.navigate("bottomNav") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        } else {
            Toast.makeText(context, "please login first", Toast.LENGTH_SHORT).show()
            navController.navigate("login") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }


    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.company_logo),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }

//@Composable
//fun Splash() {
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                brush = Brush.radialGradient(
//                    colors = if (isSystemInDarkTheme()) {
//                    listOf(Color.Black, Color.DarkGray)
//                    }
//                else{
//                    listOf(Color.White, Color.LightGray)
//                    }
//                )
//            ),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.company_logo),
//            contentDescription = "company Logo",
//            modifier = Modifier.size(200.dp)
//        )
//    }
//}
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())

}